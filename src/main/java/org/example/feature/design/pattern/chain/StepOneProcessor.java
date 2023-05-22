package org.example.feature.design.pattern.chain;

public class StepOneProcessor extends VerifyProcessor {
    @Override
    public int handler() {
        // some logic
        System.out.println("execute one");
        if (next != null) {
            return next.handler();
        }

        return 1;
    }
}
