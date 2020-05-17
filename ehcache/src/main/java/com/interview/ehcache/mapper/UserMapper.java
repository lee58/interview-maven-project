package com.interview.ehcache.mapper;

import com.interview.ehcache.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author 大都督
 * @create 2020/3/26
 */
@Mapper
@CacheConfig(cacheNames = "baseCache")
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE NAME = #{name}")
    @Cacheable
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USERS(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
