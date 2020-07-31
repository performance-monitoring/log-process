package com.chenxinzouzou.logprocesselasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ElasticSearch配置
 *
 * @author ：chenxin
 * @date ：Created in 2020/7/19 11:16
 */
@Configuration
public class ElasticSearchConfig {
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("chenxinzouzou.cn", 9200, "http")));
    }

}
