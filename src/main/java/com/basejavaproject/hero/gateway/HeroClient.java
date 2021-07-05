package com.basejavaproject.hero.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hero-client", url = "${hero-api.base-url}", configuration = HeroClientConfiguration.class)
interface HeroClient {

    @GetMapping(value = "/v1/public/characters")
    HeroResponse getHeroPaginated(@RequestParam(name = "limit") int limit, @RequestParam(name = "offset") int offset);




}
