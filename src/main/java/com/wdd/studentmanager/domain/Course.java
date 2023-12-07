package com.wdd.studentmanager.domain;

/**
 * 课程实体类
 * 用于表示课程的相关信息
 * @Classname Course
 * @Description None
 * @Date 2023/11/29 20:06
 * @Created
 */
public class Course {
    private int id; // 课程ID
    private String name; // 课程名称
    private int teacherId; // 教师ID
    private String courseDate; // 课程日期
    private int selectedNum = 0; // 已选人数
    private int maxNum = 50; // 课程最大选课人数
    private String info; // 课程信息

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public int getSelectedNum() {
        return selectedNum;
    }

    public void setSelectedNum(int selectedNum) {
        this.selectedNum = selectedNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
