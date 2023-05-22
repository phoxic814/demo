package org.example.feature.express;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class ExpressionContext implements IntPredicate {

    private BiPredicate<Integer, CustomCondition> evaluator;

    public ExpressionContext(BiPredicate<Integer, CustomCondition> evaluator) {
        this.evaluator = evaluator;
    }

    public CustomCondition build() {
        return CustomCondition.builder()
                .status(1)
                .build();
    }

    @Override
    public boolean test(int value) {
        // 模擬資料
        return evaluator.test((int) (Math.random() * 5) + 1, build());
    }
}
