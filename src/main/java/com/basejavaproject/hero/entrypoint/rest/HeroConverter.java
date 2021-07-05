package com.basejavaproject.hero.entrypoint.rest;

import com.basejavaproject.hero.usecase.HeroDomain;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class HeroConverter {

    static HeroResponse toResponse(HeroDomain heroDomain) {
        return Optional.ofNullable(heroDomain)
                .map(domain ->
                        HeroResponse.builder()
                                .count(domain.getCount())
                                .limit(domain.getLimit())
                                .offset(domain.getOffset())
                                .total(domain.getTotal())
                                .heroes(Optional.ofNullable(domain.getHeroes()).orElseGet(Collections::emptyList).stream()
                                        .map(heroInfo -> HeroResponse.HeroInfoResponse.builder()
                                                .id(heroInfo.getId())
                                                .description(heroInfo.getDescription())
                                                .name(heroInfo.getName())
                                                .build()
                                        ).collect(Collectors.toUnmodifiableList()))
                                .build())
                .orElse(null);
    }
}
