package com.chenxinzouzou.logprocesselasticsearch.controller;

import com.chenxinzouzou.logprocesselasticsearch.service.ElasticSearchGetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：chenxin
 * @date ：Created in 2020/7/31 22:33
 */
@RestController
public class ElasticSearchGetController {

    @Resource
    private ElasticSearchGetService esGetService;

}
