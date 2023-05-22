package org.example.feature.design.pattern.factory;

public class BankPay implements IPayment {

    @Override
    public boolean pay(PaymentDao paymentDao) {
        System.out.println("Bank pay");
        return true;
    }
}
