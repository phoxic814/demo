package org.example.feature.design.pattern.chain;

public enum ProcessorEnum {
    ONE_PROCESSOR(1, new StepOneProcessor()),
    TWO_PROCESSOR(2, new StepTwoProcessor()),
    THREE_PROCESSOR(3, new StepThreeProcessor()),
    ;

    int order;
    VerifyProcessor verifyProcessor;

    ProcessorEnum(int i, VerifyProcessor verifyProcessor) {
    }

    public int getOrder() {
        return order;
    }

    public VerifyProcessor getVerifyProcessor() {
        return verifyProcessor;
    }
}
