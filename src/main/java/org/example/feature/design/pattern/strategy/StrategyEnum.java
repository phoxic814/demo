package org.example.feature.design.pattern.strategy;

import lombok.Data;
import lombok.Getter;

@Getter
public enum StrategyEnum {

    STRATEGY_A(1, "strategyA"),
    STRATEGY_B(2, "strategyB"),
    STRATEGY_C(3, "strategyC"),
    ;

    private Integer code;
    private String strategy;

    StrategyEnum(Integer code, String strategy) {
        this.code = code;
        this.strategy = strategy;
    }
}
