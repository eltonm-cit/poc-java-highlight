package com.basejavaproject.hero.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HeroDomain {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<HeroInfoDomain> heroes;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class HeroInfoDomain {
        private int id;
        private String name;
        private String description;
    }

}
