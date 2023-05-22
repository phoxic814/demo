package org.example.feature.design.pattern.strategy;

/**
 * 场景: 商场搞活动，根据客户购买商品的金额，收费时给与不同的打折，比如，购买 金额>=2000 的打八折(0.8)，金额 500 ~ 1000 的，打九折(0.9)，购买金额 0 ~ 500 的九五折(0.95)，根据不同的金额走不同计算策略逻辑。
 */
public interface Strategy {

    /**
     * 策略
     */
    String strategy();

    /**
     * 算法
     */
    void algorithm();
}
