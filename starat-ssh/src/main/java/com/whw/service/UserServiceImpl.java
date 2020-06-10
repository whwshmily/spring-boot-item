package com.whw.service;

import com.whw.dao.UserDao;
import com.whw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;

    /**
     * 根据用户名字查询用户
     *
     * @param name 用户名字
     * @return 返回user对象  查不到 null
     */
    public User findByUserName(String name) {
        try {
            return dao.findByUserName(name);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 新增用户
     *
     * @param user
     * @return 成功 返回 id 失败 -1；
     */
    public int save(User user) {
        try {
            return dao.save(user);
        } catch (Exception e) {

        }
        return -1;
    }

    /**
     * 根据id 查用户
     *
     * @param id id
     * @return 成功 user  失败 null
     */
    public User findById(int id) {
        try {
            return dao.findById(id);
        } catch (Exception e) {

        }
        return null;
    }
}
