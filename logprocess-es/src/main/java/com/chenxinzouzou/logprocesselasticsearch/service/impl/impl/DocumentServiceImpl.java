package com.chenxinzouzou.logprocesselasticsearch.service.impl.impl;

import com.chenxinzouzou.logprocesscommon.CommonResult;
import com.chenxinzouzou.logprocesselasticsearch.service.impl.DocumentService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
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
    public CommonResult indexDocment(String index, String id, String jsonData) throws IOException {
        IndexRequest request = new IndexRequest(index);
        request.id(id);
        request.source(jsonData, XContentType.JSON);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        return CommonResult.success(indexResponse);
    }
}
