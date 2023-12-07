package com.wdd.studentmanager.util;

/**
 * 生成学号和教师编号
 * 通过组合班级ID和当前的时间戳来生成唯一的学生或教师编号
 *
 * @Classname SnGenerateUtil
 * @Description 用于随机生成学号的工具类
 * @Date 2019/6/27 20:17
 * @Created by WDD
 */
public class SnGenerateUtil {

    /**
     * 生成学号
     * 学号格式为："S" + 班级ID + 当前时间戳
     *
     * @param clazzId 班级ID
     * @return 生成的学生学号
     */
    public static String generateSn(int clazzId){
        return "S" + clazzId + System.currentTimeMillis();
    }

    /**
     * 生成教师编号
     * 教师编号格式为："T" + 班级ID + 当前时间戳
     *
     * @param clazzId 班级ID
     * @return 生成的教师编号
     */
    public static String generateTeacherSn(int clazzId){
        return "T" + clazzId + System.currentTimeMillis();
    }
}
