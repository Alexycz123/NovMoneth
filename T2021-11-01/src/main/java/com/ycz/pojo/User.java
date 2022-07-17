package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-02-18:23
*/

public class User {
    private Integer id;
    private String name;

    public User(Integer id, String name, String pwd, String phone) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
    }
    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String pwd;
    private String phone;

}
