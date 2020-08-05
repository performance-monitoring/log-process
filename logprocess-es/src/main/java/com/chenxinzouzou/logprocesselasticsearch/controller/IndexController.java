package com.chenxinzouzou.logprocesselasticsearch.controller;

import com.chenxinzouzou.logprocesscommon.CommonResult;
import com.chenxinzouzou.logprocesselasticsearch.service.impl.IndexService;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author ：chenxin
 * @date ：Created in 2020/8/5 22:53
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexService indexService;

    @PostMapping("/{index}")
    public CommonResult<CreateIndexResponse> creatIndex(@PathVariable("index") String index) throws IOException {
        return indexService.creatIndex(index);
    }
}
