package com.chenxinzouzou.logprocesselasticsearch.controller;

import com.chenxinzouzou.logprocesscommon.CommonResult;
import com.chenxinzouzou.logprocesselasticsearch.service.impl.DocumentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author ：chenxin
 * @date ：Created in 2020/8/5 23:00
 */
@RestController
@RequestMapping("document")
public class DocumentController {

    @Resource
    private DocumentService documentService;

    @PostMapping("")
    public CommonResult postDocument(String index,String id,String data) throws IOException {
        return documentService.indexDocment(index, id, data);
    }
}
