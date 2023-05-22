package org.example.controller;

import org.example.datasource.DataSourceEnum;
import org.example.datasource.DataSourceSwitcher;
import org.example.repository.dao.User;
import org.example.repository.dao.UserDetail;
import org.example.repository.impl.UserDetailRepository;
import org.example.repository.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MutiDataSourceController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @GetMapping("user")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @GetMapping("userDetail")
    @DataSourceSwitcher(DataSourceEnum.SLAVE)
    public List<UserDetail> detailList() {
        return userDetailRepository.findAll();
    }
}
