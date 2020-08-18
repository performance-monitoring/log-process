package com.chenxinzouzou.logprocesselasticsearch.service.impl;

import com.chenxinzouzou.logprocesscommon.CommonResult;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * elasticSearch 索引相关操作
 *
 * @author ：chenxin
 * @date ：Created in 2020/8/3 19:15
 */
public interface IndexService {

    /**
     * 通过索引名创建索引
     *
     * @param index 索引名
     * @return com.chenxinzouzou.logprocesscommon.CommonResult
     * @author chenxin
     * @date 2020/8/5 22:34
     **/
    CommonResult<CreateIndexResponse> creatIndex(String index) throws IOException;

    CommonResult deleteIndex(String index) throws IOException;
}
