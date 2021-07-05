package com.basejavaproject.highlight.entrypoint.rest;

import com.basejavaproject.highlight.usecase.HighlightDomain;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HighlightConverter {

    static List<HighlightResponse> toResponse(List<HighlightDomain> domains) {
        return Optional.of(domains).orElseGet(Collections::emptyList).stream()
                .map(domain -> HighlightResponse.builder()
                        .type(domain.getType().name())
                        .word(domain.getWord())
                        .build())
                .collect(Collectors.toUnmodifiableList());
    }
}
