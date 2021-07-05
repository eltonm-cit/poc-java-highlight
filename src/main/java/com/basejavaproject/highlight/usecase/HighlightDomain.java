package com.basejavaproject.highlight.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HighlightDomain {
    private String word;
    private HighlightType type;

}
