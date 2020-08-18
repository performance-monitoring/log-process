package com.chenxinzouzou.logprocesselasticsearch.service.impl;

import com.chenxinzouzou.logprocesscommon.CommonResult;

import java.io.IOException;

/**
 * @author ：chenxin
 * @date ：Created in 2020/8/3 19:21
 */
public interface DocumentService {

    CommonResult indexDocment(String index, String id, String jsonData) throws IOException;

    CommonResult getAllDocment() throws IOException;

    CommonResult getDocmentByIndexAndId(String index, String id) throws IOException;

    CommonResult deleteDocmentByIndexAndId(String index, String id) throws IOException;
}
