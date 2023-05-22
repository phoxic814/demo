package org.example.service;

import org.example.annotation.RuleValidate;
import org.example.annotation.RuleValidate.Rule;
import org.springframework.stereotype.Service;

@Service
public class RuleValidateService {

    @RuleValidate(rule = Rule.MIN)
    public void addPrice(String name, int price) {
        System.out.println("execute addPrice");
    }

    @RuleValidate(rule = Rule.MIN)
    public void updatePrice(String name, int price) {
        System.out.println("execute updatePrice");
    }
}
