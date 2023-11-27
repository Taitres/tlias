package com.taitres.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean //第三方bean的管理 将当前方法的返回值交给spring容器管理
    public SAXReader saxReader(){
        return new SAXReader();
    }

}
