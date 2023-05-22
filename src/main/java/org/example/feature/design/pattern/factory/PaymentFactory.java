package org.example.feature.design.pattern.factory;

import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

    public static IPayment getPayStrategy(String type) throws Exception {
        PaymentEnum payStrategy = PaymentEnum.getEnum(type);
        if (payStrategy == null) {
            throw new IllegalArgumentException("payment not support");
        }

        Class<?> c = Class.forName(payStrategy.getValue());
        IPayment payment = (IPayment) c.getDeclaredConstructor().newInstance();
        return payment;
    }
}
