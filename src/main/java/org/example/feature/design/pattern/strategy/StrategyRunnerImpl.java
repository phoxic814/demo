package org.example.feature.design.pattern.strategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StrategyRunnerImpl implements StrategyRunner {

    private static final List<Strategy> strategies = Arrays.asList(new StrategyA());
    private static Map<String, Strategy> map = new HashMap<>();

    static {
        map = strategies.stream().collect(Collectors.toMap(Strategy::strategy, s-> s));
    }

    @Override
    public void execute(String strategy) {
        map.get(strategy).algorithm();
    }
}
