package com.chenxinzouzou.logprocesselasticsearch.service.impl.impl;

import com.chenxinzouzou.logprocesscommon.CommonResult;
import com.chenxinzouzou.logprocesscommon.ResultCode;
import com.chenxinzouzou.logprocesselasticsearch.service.impl.IndexService;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.rest.RestStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * elasticSearch 索引相关操作实现
 *
 * @author ：chenxin
 * @date ：Created in 2020/8/5 22:35
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    public RestHighLevelClient client;


    @Override
    public CommonResult<CreateIndexResponse> creatIndex(String index) throws IOException {

        CreateIndexResponse indexResponse = client.indices().create(new CreateIndexRequest(index), RequestOptions.DEFAULT);

        return CommonResult.success(indexResponse);
    }

    @Override
    public CommonResult deleteIndex(String index) throws IOException {
        try {
            AcknowledgedResponse delete = client.indices().delete(new DeleteIndexRequest(index), RequestOptions.DEFAULT);
            if (delete.isAcknowledged()) {
                return CommonResult.success(delete);
            } else {
                return CommonResult.failed(delete.toString());
            }
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.NOT_FOUND) {
                return CommonResult.validateFailed();
            } else {
                return CommonResult.failed(exception.getMessage());
            }
        }
    }
}
