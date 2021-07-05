package com.basejavaproject.hero.gateway;

import com.basejavaproject.hero.usecase.HeroDomain;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HeroGateway {

    private final HeroClient client;

    public HeroDomain getHeroesPaginated(int limit, int offset) {
        return HeroConverter.toDomain(
                Try.ofSupplier(
                        Decorators.ofSupplier(() -> client.getHeroPaginated(limit, offset))
                                .withCircuitBreaker(CircuitBreaker.ofDefaults(client.getClass().getName()))
                                .withBulkhead(Bulkhead.ofDefaults(client.getClass().getName()))
                                .withRetry(Retry.ofDefaults(client.getClass().getName()))
                                .decorate())
                        .recover(throwable -> {
                                    log.warn("Has an error in hero client", throwable);
                                    return HeroResponse.builder()
                                            .data(HeroResponse.Data.builder()
                                                    .count(0)
                                                    .offset(offset)
                                                    .limit(limit)
                                                    .total(0)
                                                    .build()
                                            ).build();
                                }
                        ).get()
        );
    }
}
