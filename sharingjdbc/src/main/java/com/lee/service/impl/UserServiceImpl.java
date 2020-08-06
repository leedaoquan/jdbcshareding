package com.lee.service.impl;

import com.lee.dao.UserRepository;
import com.lee.domain.UserPO;
import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    public void save(UserPO userPO) {
        userRepository.save(userPO);
    }

    public UserPO get(Integer id) {
        return userRepository.getOne(id);
    }

    public void update(UserPO userPO) {

    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
