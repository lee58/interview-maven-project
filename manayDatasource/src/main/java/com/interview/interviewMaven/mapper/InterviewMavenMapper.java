package com.interview.interviewMaven.mapper;

import com.interview.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@Mapper
public interface InterviewMavenMapper {
    @Select("select * from users where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into users (name, age) values (#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
