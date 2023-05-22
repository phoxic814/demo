package org.example.feature.express;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.function.BiPredicate;

public class CustomEvaluator extends SpelExpressionParser {

    public Boolean evaluate(BiPredicate<Integer, CustomCondition> evaluator) {
        Expression expression = this.parseExpression("");
        Boolean o = expression.getValue(new CustomEvaluationContext(new ExpressionContext(evaluator)), Boolean.class);
        return o;
    }

    // 模擬check邏輯
    private static boolean checkCondition(Integer status, CustomCondition condition) {
        System.out.println(status);
        return condition.getStatus().equals(status);
    }

    public static void main(String[] args) {
        CustomEvaluator evaluator = new CustomEvaluator();
        Boolean o = evaluator.evaluate(CustomEvaluator::checkCondition);
        System.out.println(o);
    }
}
