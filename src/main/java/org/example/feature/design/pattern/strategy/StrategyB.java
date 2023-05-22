package org.example.feature.design.pattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyB implements Strategy {

    @Override
    public String strategy() {
        return StrategyEnum.STRATEGY_B.getStrategy();
    }

    @Override
    public void algorithm() {
        System.out.println("Mock strategy B algorithm");
    }
}
