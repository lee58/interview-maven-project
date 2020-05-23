package com.interview.reflex.entity;

import com.interview.reflex.entity.BaseEntity;

/**
 * @author 大都督
 * @create 2020/5/22
 */

public class User extends BaseEntity {
    private Long userId;
    private String userName;
    private Integer userAge;
    public Integer userSex;
    public String userHeight;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }
}
