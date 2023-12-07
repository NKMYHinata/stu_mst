package com.wdd.studentmanager.domain;

/**
 * 教师实体类
 * 用于表示教师的基本信息
 * @Classname Teacher
 * @Description None
 * @Date 2023/11/28 18:55
 * @Created
 */
public class Teacher {
    private int id; // 教师ID
    private String sn; // 教师工号
    private String username; // 用户名
    private String password; // 密码
    private int clazzId; // 所属班级ID
    private String sex = "男"; // 性别，默认为男
    private String mobile; // 手机号码
    private String qq; // QQ号码
    private String photo; // 头像

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
