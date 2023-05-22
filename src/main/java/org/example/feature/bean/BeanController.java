package org.example.feature.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {

    @Autowired
    private TestUserBean testUserBean;

    @GetMapping("bean")
    public void test() {
        testUserBean.getId();
    }
}
