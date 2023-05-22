package org.example.feature.design.pattern.factory;

public class UnionPay implements IPayment {

    @Override
    public boolean pay(PaymentDao paymentDao) {
        System.out.println("Union pay");
        return true;
    }
}
