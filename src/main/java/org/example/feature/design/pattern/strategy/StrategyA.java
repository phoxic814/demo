package org.example.feature.design.pattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyA implements Strategy {

    @Override
    public String strategy() {
        return StrategyEnum.STRATEGY_A.getStrategy();
    }

    @Override
    public void algorithm() {
        System.out.println("Mock strategy A algorithm");
    }
}
