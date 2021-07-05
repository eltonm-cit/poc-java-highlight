package com.basejavaproject.hero.gateway;

import com.basejavaproject.hero.usecase.HeroDomain;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class HeroConverter {

    static HeroDomain toDomain(HeroResponse response) {
        return Optional.ofNullable(response)
                .map(resp -> HeroDomain.builder()
                        .count(resp.getData().getCount())
                        .limit(resp.getData().getLimit())
                        .offset(resp.getData().getOffset())
                        .total(resp.getData().getTotal())
                        .heroes(Optional.ofNullable(resp.getData().getResults()).orElseGet(Collections::emptyList).stream()
                                .map(result -> HeroDomain.HeroInfoDomain.builder()
                                        .id(result.getId())
                                        .description(result.getDescription())
                                        .name(result.getName())
                                        .build()
                                ).collect(Collectors.toUnmodifiableList()))
                        .build())
                .orElse(HeroDomain
                        .builder()
                        .build());
    }
}
