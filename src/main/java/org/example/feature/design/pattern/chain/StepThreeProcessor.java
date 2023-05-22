package org.example.feature.design.pattern.chain;

public class StepThreeProcessor extends VerifyProcessor {
    @Override
    public int handler() {
        // some logic
        System.out.println("execute three");
        if (next != null) {
            return next.handler();
        }

        return 3;
    }
}
