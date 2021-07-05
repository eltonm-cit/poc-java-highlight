package com.basejavaproject.hero.usecase

import com.basejavaproject.hero.gateway.HeroGateway
import spock.lang.Specification


class GetHeroesPaginatedTest extends Specification {

    private HeroGateway gateway = Mock()
    private GetHeroesPaginated useCase = new GetHeroesPaginated(gateway)

    def "Should be return heroes successful"() {
        given: "A valid limit"
        int limit = new Random().nextInt()

        and: "A valid offset"
        int offset = new Random().nextInt()

        and: "A valid response from gateway"
        HeroDomain gatewayResponse = HeroDomain.builder()
                .limit(new Random().nextInt())
                .offset(new Random().nextInt())
                .total(new Random().nextInt())
                .count(new Random().nextInt())
                .heroes(Arrays.asList(
                        HeroDomain.HeroInfoDomain.builder()
                                .id(new Random().nextInt())
                                .name(UUID.randomUUID().toString())
                                .description(UUID.randomUUID().toString())
                                .build(),
                        HeroDomain.HeroInfoDomain.builder()
                                .id(new Random().nextInt())
                                .name(UUID.randomUUID().toString())
                                .description(UUID.randomUUID().toString())
                                .build(),
                        HeroDomain.HeroInfoDomain.builder()
                                .id(new Random().nextInt())
                                .name(UUID.randomUUID().toString())
                                .description(UUID.randomUUID().toString())
                                .build()))
                .build()
        1 * gateway.getHeroesPaginated(_, _) >> {
            args ->
                assert args[0] == limit && args[1] == offset
                return gatewayResponse
        }

        when: "Use case was called"
        HeroDomain domain = useCase.execute(limit, offset)

        then: "A valid response was returned"
        domain == gatewayResponse
    }
}
