package com.basejavaproject.hero.usecase;

import com.basejavaproject.configuration.log.LogKey;
import com.basejavaproject.hero.gateway.HeroGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetHeroesPaginated {

    private final HeroGateway gateway;

    public HeroDomain execute(int limit, int offset) {
        log.info("Start get heroes [{}, {}]",
                kv(LogKey.LIMIT.getKey(), limit),
                kv(LogKey.OFFSET.getKey(), offset)
        );

        HeroDomain domain = gateway.getHeroesPaginated(limit, offset);

        log.info("Get heroes successful [{}, {}, {}]",
                kv(LogKey.LIMIT.getKey(), limit),
                kv(LogKey.OFFSET.getKey(), offset),
                kv(LogKey.TOTAL.getKey(), domain.getTotal())
        );

        return domain;
    }
}
