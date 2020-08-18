package com.chenxinzouzou.logprocesselasticsearch.service.impl.impl;

import com.chenxinzouzou.logprocesscommon.CommonResult;
import com.chenxinzouzou.logprocesselasticsearch.service.impl.DocumentService;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author ：chenxin
 * @date ：Created in 2020/8/3 19:21
 */
@Service
public class DocumentServiceImpl implements DocumentService {


    @Resource
    public RestHighLevelClient client;

    @Override
    public CommonResult indexDocment(String index, String id, String data) throws IOException {
        IndexRequest request = new IndexRequest(index);
        request.id(id);
        request.source(data, XContentType.JSON);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        return CommonResult.success(indexResponse);
    }

    @Override
    public CommonResult getAllDocment() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        return CommonResult.success(search);
    }

    @Override
    public CommonResult getDocmentByIndexAndId(String index, String id) throws IOException {
        GetRequest zouzou = new GetRequest(index, id);
        GetResponse getResponse = client.get(zouzou, RequestOptions.DEFAULT);
        return CommonResult.success(getResponse.getSourceAsMap());
    }

    @Override
    public CommonResult deleteDocmentByIndexAndId(String index, String id) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index, id);
        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
        //处理成功切分的数目小于切分总数的情况
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {

        }
        //潜在的失败
        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure :
                    shardInfo.getFailures()) {
                String reason = failure.reason();
                return CommonResult.failed(reason);
            }
        }
        //文档没找到
        if (deleteResponse.getResult() == DocWriteResponse.Result.NOT_FOUND) {
            return CommonResult.validateFailed();
        }
        return CommonResult.success(deleteResponse);
    }
}
