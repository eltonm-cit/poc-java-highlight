package com.basejavaproject.highlight.entrypoint.rest;

import com.basejavaproject.highlight.usecase.GetTextHighlight;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("highlight")
@RequiredArgsConstructor
@CrossOrigin
public class HighlightController {

    private final GetTextHighlight getTextHighlight;

    @GetMapping
    public List<HighlightResponse> getHighlights(@RequestParam String text) {
        return HighlightConverter.toResponse(
                getTextHighlight.execute(text)
        );
    }

}
