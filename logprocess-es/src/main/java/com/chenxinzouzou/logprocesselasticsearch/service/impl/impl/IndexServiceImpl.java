package com.chenxinzouzou.logprocesselasticsearch.service.impl.impl;

import com.chenxinzouzou.logprocesscommon.CommonResult;
import com.chenxinzouzou.logprocesselasticsearch.service.impl.IndexService;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
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
}
