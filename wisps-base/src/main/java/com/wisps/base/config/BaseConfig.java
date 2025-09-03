package com.wisps.base.config;

import com.wisps.base.utils.SpringContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通用模块的配置类
 *
 */
@Configuration
public class BaseConfig {

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
