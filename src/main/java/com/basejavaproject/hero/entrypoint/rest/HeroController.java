package com.basejavaproject.hero.entrypoint.rest;

import com.basejavaproject.hero.usecase.GetHeroesPaginated;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hero")
@RequiredArgsConstructor
public class HeroController {

    private final GetHeroesPaginated getHeroesPaginated;

    @GetMapping
    public HeroResponse getExamplePaginated(
            @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit,
            @RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset) {
        return HeroConverter.toResponse(getHeroesPaginated.execute(limit, offset));
    }
}
