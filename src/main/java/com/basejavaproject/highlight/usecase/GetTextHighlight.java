package com.basejavaproject.highlight.usecase;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetTextHighlight {

    public List<HighlightDomain> execute(String text) {
        return Arrays.stream(text.split(" "))
                .map(word -> HighlightDomain.builder()
                        .word(word)
                        .type(getType(word))
                        .build())
                .filter(highlight -> highlight.getType() != HighlightType.UNKNOWN)
                .collect(Collectors.toUnmodifiableList());
    }

    private HighlightType getType(String word) {
        if (word.toUpperCase().startsWith("P")) {
            return HighlightType.PRODUCT;
        } else if (word.toUpperCase().startsWith("I")) {
            return HighlightType.ITEM;
        } else {
            return HighlightType.UNKNOWN;
        }
    }
}
