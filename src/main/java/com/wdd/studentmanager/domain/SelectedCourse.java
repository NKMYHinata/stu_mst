package com.wdd.studentmanager.domain;

/**
 * 选课信息实体类
 * 用于表示学生的选课信息
 * @Classname SelectedCourse
 * @Description 选课信息实体类
 * @Date 2019/6/30 10:30
 * @Created by WDD
 */
public class SelectedCourse {
    private Integer id; // 选课信息的ID
    private Integer studentId; // 学生ID
    private Integer courseId; // 课程ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
