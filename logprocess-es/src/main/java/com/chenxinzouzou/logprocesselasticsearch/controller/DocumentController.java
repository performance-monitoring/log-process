package com.chenxinzouzou.logprocesselasticsearch.controller;

import com.chenxinzouzou.logprocesscommon.CommonResult;
import com.chenxinzouzou.logprocesselasticsearch.service.impl.DocumentService;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult postDocument(String index, String id, String data) throws IOException {
        return documentService.indexDocment(index, id, data);
    }

    @GetMapping("")
    public CommonResult getDocument() throws IOException {
        return documentService.getAllDocment();
    }

    @GetMapping("/{index}/{id}")
    public CommonResult getDocumentByIndexId(@PathVariable("index") String indexm, @PathVariable("id") String id) throws IOException {
        return documentService.getDocmentByIndexAndId(indexm, id);
    }

    @DeleteMapping("/{index}/{id}")
    public CommonResult deleteDocumentByIndexId(@PathVariable("index") String indexm, @PathVariable("id") String id) throws IOException {
        return documentService.deleteDocmentByIndexAndId(indexm, id);
    }
}
