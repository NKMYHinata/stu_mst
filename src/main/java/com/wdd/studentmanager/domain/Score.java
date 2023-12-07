package com.wdd.studentmanager.domain;

/**
 * 成绩实体类
 * 用于封装学生的课程成绩
 * @Classname Score
 * @Description 成绩实体表
 * @Date 2023/12/3 10:22
 * @Created
 */
public class Score {
    private Integer id; // 成绩ID
    private Integer studentId; // 学生ID
    private Integer courseId; // 课程ID
    private double score; // 成绩分数
    private String remark; // 成绩备注

    // 关联信息
    private String courseName; // 课程名称
    private String studentName; // 学生姓名

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
