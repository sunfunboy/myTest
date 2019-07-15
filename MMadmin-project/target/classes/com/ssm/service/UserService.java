package com.ssm.service;

import com.ssm.pojo.PageBean;
import com.ssm.pojo.User;
import com.ssm.pojo.User00;

import java.util.List;

public interface UserService {


    User loginId(String username, String password);

    List<User> queryUsers(String userAccount);

    boolean deletUser(String userId);

    boolean addUser(User user);

    boolean deletUsers(String ids);



    User getUser(String userId);

    boolean update(User00 User00);


    PageBean<User> pageUser(String userAccount, int currentPage, int pageSize);

    boolean updateHead(long userId, String url);
}
