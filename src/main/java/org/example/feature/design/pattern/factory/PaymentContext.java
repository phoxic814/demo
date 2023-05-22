package org.example.feature.design.pattern.factory;

import org.springframework.beans.factory.annotation.Autowired;

public class PaymentContext {

    @Autowired
    private IPayment payment;

    public PaymentContext(IPayment paymentStrategy) {
        this.payment = paymentStrategy;
    }

    public Boolean pay(PaymentDao paymentDao) {
        return this.payment.pay(paymentDao);
    }
}
