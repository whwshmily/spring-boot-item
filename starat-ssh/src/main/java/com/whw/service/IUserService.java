package com.whw.service;

import com.whw.domain.User;
import com.whw.util.SessionUtil;

public interface IUserService {
    /**
     * 根据用户名字查询用户
     *
     * @param name 用户名字
     * @return 返回user对象  查不到 null
     */
    User findByUserName(String name);

    /**
     * 新增用户
     *
     * @return 成功 返回 id 失败 -1；
     */
    int save(User user);

    /**
     * 根据id 查用户
     *
     * @param id id
     * @return 成功 user  失败 null
     */
    User findById(int id);
}
