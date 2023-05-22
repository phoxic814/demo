package org.example.feature.design.pattern.factory;

public class WechatPay implements IPayment {

    @Override
    public boolean pay(PaymentDao paymentDao) {
        System.out.println("wechat pay");
        return true;
    }
}
