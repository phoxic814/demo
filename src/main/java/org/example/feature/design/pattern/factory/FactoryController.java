package org.example.feature.design.pattern.factory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactoryController {

    @PostMapping("pay")
    public void pay(@RequestBody PaymentDao paymentDao) throws Exception {
        PaymentStrategyHandler.pay(paymentDao);
    }
}
