package org.example.feature.design.pattern.strategy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class StrategyConfig {

    @Bean
    public StrategyRunner strategyRunner(List<Strategy> strategies) {
        Map<String, Strategy> map = strategies.stream().collect(Collectors.toMap(Strategy::strategy, s -> s));
        return flag -> map.get(flag).algorithm();
    }
}
