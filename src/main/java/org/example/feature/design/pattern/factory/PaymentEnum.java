package org.example.feature.design.pattern.factory;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PaymentEnum {

    BANK("BANK", "org.example.feature.design.pattern.factory.BankPay"),
    ;

    String type;
    String value;

    PaymentEnum(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public static PaymentEnum getEnum(String name) {
        return Arrays.stream(PaymentEnum.values()).filter(e -> e.name().equals(name)).findFirst().orElse(null);
    }
}
