package org.example.feature.design.pattern.factory;

import org.springframework.stereotype.Component;

@Component
public class PaymentStrategyHandler {

    public static boolean pay(PaymentDao paymentDao) throws Exception {
        IPayment payStrategy = PaymentFactory.getPayStrategy(paymentDao.getType());
        PaymentContext paymentContext = new PaymentContext(payStrategy);
        return paymentContext.pay(paymentDao);
    }
}
