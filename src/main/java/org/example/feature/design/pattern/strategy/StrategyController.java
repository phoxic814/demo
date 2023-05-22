package org.example.feature.design.pattern.strategy;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrategyController {

    @Autowired
    private StrategyRunner strategyRunner;

    @GetMapping("execute")
    public void execute(@RequestParam String strategy) {
        strategyRunner.execute(strategy);
    }
}
