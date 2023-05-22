package org.example.feature.design.pattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyC implements Strategy {

    @Override
    public String strategy() {
        return StrategyEnum.STRATEGY_C.getStrategy();
    }

    @Override
    public void algorithm() {
        System.out.println("Mock strategy C algorithm");
    }
}
