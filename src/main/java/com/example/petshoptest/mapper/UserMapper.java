package com.example.petshoptest.mapper;


import com.example.petshoptest.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

    User selectByNameAndPwd(User user);

    User selectById(Integer id);

    int insert(User user);

    int update(User user);

    int deleteByPrimaryKey(Integer id);

    int selectIsName(User user);

    List<User> selectAll();
}
