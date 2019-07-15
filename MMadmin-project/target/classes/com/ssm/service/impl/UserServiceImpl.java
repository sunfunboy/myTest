package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.PageBean;
import com.ssm.pojo.User;
import com.ssm.pojo.User00;
import com.ssm.service.UserService;
import com.ssm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginId(String username, String password) {
        return userMapper.loginId(username, MD5Utils.encrypt(password));
    }

    @Override
    public List<User> queryUsers(String userAccount) {
        return userMapper.queryUsers(userAccount);
    }

    @Override
    public boolean deletUser(String userId) {
        return userMapper.deletUser(userId);
    }

    @Override
    public boolean addUser(User user) {
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        user.setCreateTime(new Date());
        user.setStatus(1);
        return userMapper.addUser(user);
    }

    @Override
    public User getUser(String userId) {

        return userMapper.getUser(userId);
    }

    @Override
    public boolean update(User00 user00) {
        return userMapper.update(user00);
    }

    @Override
    public boolean deletUsers(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return false;
        }
            String[] array = ids.split(",");
            if (array != null && array.length > 0) {
                int i = userMapper.deletUsers(array);
                return i > 0;
            }
            return false;

        }

    @Override
    public PageBean<User> pageUser(String userAccount, int currentPage, int pageSize) {
        PageBean<User> pb = new PageBean<>();
        pb.setPagesize(pageSize);
        pb.setConutpage(currentPage);
        int total = userMapper.seletUserCount(userAccount);
        pb.setTotal(total);
        List<User> list = userMapper.seletUserPage(userAccount,(currentPage-1)*pageSize,pageSize);
        pb.setData(list);

        return pb;
    }

    @Override
    public boolean updateHead(long userId, String url) {
        return userMapper.updateHead(userId,url)>0;
    }


}

