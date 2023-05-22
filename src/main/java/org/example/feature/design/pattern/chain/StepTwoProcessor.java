package org.example.feature.design.pattern.chain;

public class StepTwoProcessor extends VerifyProcessor {
    @Override
    public int handler() {
        // some logic
        System.out.println("execute two");
        if (next != null) {
            return next.handler();
        }

        return 2;
    }
}
