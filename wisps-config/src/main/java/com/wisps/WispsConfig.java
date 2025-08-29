package com.wisps;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "com.wisps")
public class WispsConfig {
}
