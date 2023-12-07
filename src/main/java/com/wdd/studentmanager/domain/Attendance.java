package com.wdd.studentmanager.domain;

/**
 * 考勤实体类
 * 用于表示学生考勤信息
 * @Classname Attendance
 * @Description 考勤实体类
 * @Date 2019/7/1 11:52
 * @Created by WDD
 */
public class Attendance {
    private Integer id; // 考勤记录的唯一标识
    private Integer courseId; // 课程ID
    private Integer studentId; // 学生ID
    private String type; // 考勤类型（如出勤、缺勤等）
    private String date; // 考勤日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
