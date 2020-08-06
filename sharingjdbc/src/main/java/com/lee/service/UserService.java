package com.lee.service;

import com.lee.domain.UserPO;

public interface UserService {
    //保存
    void save(UserPO userPO);
    //获取
    UserPO get(Integer id);
    //更新
    void update(UserPO userPO);
    //删除
    void delete(Integer id);
}
