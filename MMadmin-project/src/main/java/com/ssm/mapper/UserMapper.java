package com.ssm.mapper;

import com.ssm.pojo.User00;
import org.apache.ibatis.annotations.Param;
import com.ssm.pojo.User;

import java.util.List;

public interface UserMapper {

    User loginId(@Param("username") String username, @Param("password") String password);

    List<User> queryUsers(@Param("userAccount") String userAccount);

    boolean deletUser(@Param("userId") String userId);

    boolean addUser(User user);

   int deletUsers(@Param("ids") String[] split);

    User getUser(@Param("userId") String userId);

    boolean update(User00 user00);

    int seletUserCount(@Param("uname") String account);

    List<User> seletUserPage(@Param("uname") String account ,@Param("begin") int currunt,@Param("limt") int pageSize);

    int updateHead(@Param("userId") long userId,@Param("url") String url);
}
