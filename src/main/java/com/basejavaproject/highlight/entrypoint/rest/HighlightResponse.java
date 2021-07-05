package com.basejavaproject.highlight.entrypoint.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HighlightResponse {
    private String word;
    private String type;

}
