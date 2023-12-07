package com.wdd.studentmanager.domain;

/**
 * 请假表实体类
 * 用于表示学生的请假信息
 * @Classname Leave
 * @Description 请假表实体类
 * @Date 2019/7/2 13:57
 * @Created by WDD
 */
public class Leave {
    public static final int LEAVE_STATUS_WAIT = 0; // 等待审核状态
    public static final int LEAVE_STATUS_AGREE = 1; // 同意状态
    public static final int LEAVE_STATUS_DISAGREE = -1; // 不同意状态

    private int id; // 请假条ID
    private int studentId; // 学生ID
    private String info; // 请假理由
    private int status = LEAVE_STATUS_WAIT; // 请假条当前状态，默认为等待审核
    private String remark; // 批复内容

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
