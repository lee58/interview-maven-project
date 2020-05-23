package com.interview.reflex.entity;

/**
 * @author 大都督
 * @create 2020/5/23
 */
public class UserEntity {
    private String userId;
    private String userName;

    /**
     * 无参构造函数
     */
    public UserEntity() {
        System.out.println("进无参构造函数了");
    }

    /**
     * 有参构造函数
     * @param userName
     */
    public UserEntity(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
