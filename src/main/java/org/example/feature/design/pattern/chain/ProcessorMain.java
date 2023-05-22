package org.example.feature.design.pattern.chain;

public class ProcessorMain {

    public static void main(String[] args) {
        StepOneProcessor one = new StepOneProcessor();
        StepTwoProcessor two = new StepTwoProcessor();
        StepThreeProcessor three = new StepThreeProcessor();

        // 可自由定義順序
        three.setNext(one);
        one.setNext(two);

        // 3 > 1 > 2
        three.handler();

        // use factory
//        VerifyProcessor processor = ProcessorFactory.getFirstProcessor();
//        processor.handler();
    }
}
