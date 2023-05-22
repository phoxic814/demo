package org.example.feature.design.pattern.factory;

/**
 * 用户支付场景，目前支持支付宝支付和微信支付，未来会新增银行卡。使用策略模式，每一种支付方式都是一种策略，根据用户传入的支付类型，创建不同的策略类，
 * 使用工厂模式，通过封装一个PaymentStrategyHandler策略处理类，其他系统直接通过一个统一的入口，进行该功能的调用，使用门面模式。
 */
public interface IPayment {

    boolean pay(PaymentDao paymentDao);
}
