package com.wdd.studentmanager.domain;

/**
 * 成绩统计实体类
 * 用于表示特定课程的成绩统计信息
 * @Classname ScoreStats
 * @Description 成绩统计
 * @Date 2023/12/4 13:30
 * @Created
 */
public class ScoreStats {
    private Double max_score; // 最高分
    private Double avg_score; // 平均分
    private Double min_score; // 最低分
    private String courseName; // 课程名称

    public Double getMax_score() {
        return max_score;
    }

    public void setMax_score(Double max_score) {
        this.max_score = max_score;
    }

    public Double getAvg_score() {
        return avg_score;
    }

    public void setAvg_score(Double avg_score) {
        this.avg_score = avg_score;
    }

    public Double getMin_score() {
        return min_score;
    }

    public void setMin_score(Double min_score) {
        this.min_score = min_score;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
