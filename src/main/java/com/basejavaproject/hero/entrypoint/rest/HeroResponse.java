package com.basejavaproject.hero.entrypoint.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
class HeroResponse {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<HeroInfoResponse> heroes;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class HeroInfoResponse {
        private int id;
        private String name;
        private String description;
    }

}
