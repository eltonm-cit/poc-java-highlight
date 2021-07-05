package com.basejavaproject.hero.gateway;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
public class HeroClientConfiguration {

    @Value("${hero-api.public-key}")
    private String publicKey;

    @Value("${hero-api.private-key}")
    private String privateKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            try {
                Long timestamp = LocalDateTime.now().atZone(ZoneId.of("America/Los_Angeles")).toInstant().toEpochMilli();
                template.query("ts", String.valueOf(timestamp));
                template.query("apikey", publicKey);
                template.query("hash", DigestUtils.md5DigestAsHex(IOUtils.toInputStream(timestamp + privateKey + publicKey)));
            } catch (Exception e) {
                log.error("Has an error to include oAuth parameters", e);
            }
        };
    }
}
