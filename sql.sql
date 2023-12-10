-- 设置字符编码为utf8
SET NAMES utf8;

-- 设置SQL模式为空
SET SQL_MODE='';

-- 创建数据库studentmanager，如果不存在的话
CREATE DATABASE IF NOT EXISTS `studentmanager` DEFAULT CHARACTER SET utf8;

-- 使用数据库studentmanager
USE `studentmanager`;

-- 删除表s_admin如果存在
DROP TABLE IF EXISTS `s_admin`;1

-- 创建管理员表s_admin
CREATE TABLE `s_admin` (
                           `id` int(5) NOT NULL AUTO_INCREMENT,
                           `username` varchar(32) NOT NULL,
                           `password` varchar(32) NOT NULL,
                           `status` tinyint(1) NOT NULL DEFAULT '1', -- 状态，默认为1
                           PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 向s_admin表插入初始数据
insert into `s_admin`(`id`,`username`,`password`,`status`) values (1,'admin','123456',1);

-- 删除表s_attendance如果存在
DROP TABLE IF EXISTS `s_attendance`;

-- 创建考勤表s_attendance
CREATE TABLE `s_attendance` (
                                `id` int(5) NOT NULL AUTO_INCREMENT,
                                `course_id` int(5) NOT NULL, -- 课程ID
                                `student_id` int(5) NOT NULL, -- 学生ID
                                `type` varchar(11) NOT NULL, -- 考勤类型
                                `date` varchar(11) NOT NULL, -- 日期
                                PRIMARY KEY (`id`),
                                KEY `attendance_course_foreign_key` (`course_id`),
                                KEY `attendace_student_foreign_key` (`student_id`),
                                CONSTRAINT `attendace_student_foreign_key` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`),
                                CONSTRAINT `attendance_course_foreign_key` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 向s_attendance表插入数据
insert into `s_attendance`(`id`,`course_id`,`student_id`,`type`,`date`) values (13,1,2,'上午','2018-09-04'),(14,1,4,'上午','2018-09-04'),(15,2,2,'上午','2019-07-02');

-- 删除表s_clazz如果存在
DROP TABLE IF EXISTS `s_clazz`;

-- 创建班级表s_clazz
CREATE TABLE `s_clazz` (
                           `id` int(5) NOT NULL AUTO_INCREMENT,
                           `name` varchar(32) NOT NULL, -- 班级名称
                           `info` varchar(128) DEFAULT NULL, -- 描述信息
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 向s_clazz表插入数据
insert into `s_clazz`(`id`,`name`,`info`) values (1,'软件一班','软件工程专业。'),(4,'数学一班','大学数学专业'),(5,'计算机科学与技术一班','计算机专业');

-- 删除表s_course如果存在
DROP TABLE IF EXISTS `s_course`;

-- 创建课程表s_course
CREATE TABLE `s_course` (
                            `id` int(5) NOT NULL AUTO_INCREMENT,
                            `name` varchar(32) NOT NULL, -- 课程名称
                            `teacher_id` int(5) NOT NULL, -- 教师ID
                            `course_date` varchar(32) DEFAULT NULL, -- 上课时间
                            `selected_num` int(5) NOT NULL DEFAULT '0', -- 已选人数
                            `max_num` int(5) NOT NULL DEFAULT '50', -- 最大人数
                            `info` varchar(128) DEFAULT NULL, -- 课程信息
                            PRIMARY KEY (`id`),
                            KEY `course_teacher_foreign` (`teacher_id`),
                            CONSTRAINT `course_teacher_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `s_teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 向s_course表插入数据
insert into `s_course`(`id`,`name`,`teacher_id`,`course_date`,`selected_num`,`max_num`,`info`) values (1,'大学英语',9,'周三上午8点',49,50,'英语。'),(2,'大学数学',10,'周三上午10点',4,50,'数学。'),(3,'计算机基础',11,'周三上午',3,50,'计算机课程。');

-- 删除表s_leave如果存在
DROP TABLE IF EXISTS `s_leave`;

-- 创建请假表s_leave
CREATE TABLE `s_leave` (
                           `id` int(5) NOT NULL AUTO_INCREMENT,
                           `student_id` int(5) NOT NULL, -- 学生ID
                           `info` varchar(512) DEFAULT NULL, -- 请假信息
                           `status` tinyint(1) NOT NULL DEFAULT '0', -- 状态
                           `remark` varchar(512) DEFAULT NULL, -- 备注
                           PRIMARY KEY (`id`),
                           KEY `leave_student_foreign_key` (`student_id`),
                           CONSTRAINT `leave_student_foreign_key` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 向s_leave表插入数据
insert into `s_leave`(`id`,`student_id`,`info`,`status`,`remark`) values (13,2,'世界这么大，想去看看',1,'同意，你很6');

-- 删除表s_score如果存在
DROP TABLE IF EXISTS `s_score`;

-- 创建成绩表s_score
CREATE TABLE `s_score` (
                           `id` int(5) NOT NULL AUTO_INCREMENT,
                           `student_id` int(5) NOT NULL, -- 学生ID
                           `course_id` int(5) NOT NULL, -- 课程ID
                           `score` double(5,2) NOT NULL, -- 分数
                           `remark` varchar(128) DEFAULT NULL, -- 备注
                           PRIMARY KEY (`id`),
                           KEY `selected_course_student_fk` (`student_id`),
                           KEY `selected_course_course_fk` (`course_id`),
                           CONSTRAINT `s_score_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
                           CONSTRAINT `s_score_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- 向s_score表插入数据
insert into `s_score`(`id`,`student_id`,`course_id`,`score`,`remark`) values (67,4,2,78.00,'中等'),(68,9,1,50.00,'不及格');

-- 删除表s_selected_course如果存在
DROP TABLE IF EXISTS `s_selected_course`;

-- 创建选课表s_selected_course
CREATE TABLE `s_selected_course` (
                                     `id` int(5) NOT NULL AUTO_INCREMENT,
                                     `student_id` int(5) NOT NULL, -- 学生ID
                                     `course_id` int(5) NOT NULL, -- 课程ID
                                     PRIMARY KEY (`id`),
                                     KEY `selected_course_student_fk` (`student_id`),
                                     KEY `selected_course_course_fk` (`course_id`),
                                     CONSTRAINT `selected_course_course_fk` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
                                     CONSTRAINT `selected_course_student_fk` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- 向s_selected_course表插入数据
insert into `s_selected_course`(`id`,`student_id`,`course_id`) values (18,2,1),(19,2,2),(20,2,3),(21,4,3),(22,4,2),(24,9,1);

-- 删除表s_student如果存在
DROP TABLE IF EXISTS `s_student`;

-- 创建学生表s_student
CREATE TABLE `s_student` (
                             `id` int(5) NOT NULL AUTO_INCREMENT,
                             `sn` varchar(32) NOT NULL, -- 学生编号
                             `username` varchar(32) NOT NULL, -- 用户名
                             `password` varchar(32) NOT NULL, -- 密码
                             `clazz_id` int(5) NOT NULL, -- 班级ID
                             `sex` varchar(5) NOT NULL DEFAULT '男', -- 性别
                             `mobile` varchar(12) DEFAULT NULL, -- 手机号码
                             `qq` varchar(18) DEFAULT NULL, -- QQ号码
                             `photo` varchar(255) DEFAULT NULL, -- 照片
                             PRIMARY KEY (`id`,`sn`),
                             KEY `student_clazz_id_foreign` (`clazz_id`),
                             CONSTRAINT `student_clazz_id_foreign` FOREIGN KEY (`clazz_id`) REFERENCES `s_clazz` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 向s_student表插入数据
insert into `s_student`(`id`,`sn`,`username`,`password`,`clazz_id`,`sex`,`mobile`,`qq`,`photo`) values (2,'S51528202992845','张三纷','123456',1,'女','13545454548','1332365656',NULL),(4,'S51528379586807','王麻子','111111',5,'男','13356565656','123456',NULL),(9,'S41528633634989','马冬梅','1',5,'男','13333332133','131313132323','bb12326f-ef6c-4d3d-a2ae-f9eb30a15ad4.jpg');

-- 删除表s_teacher如果存在
DROP TABLE IF EXISTS `s_teacher`;

-- 创建教师表s_teacher
CREATE TABLE `s_teacher` (
                             `id` int(5) NOT NULL AUTO_INCREMENT,
                             `sn` varchar(32) NOT NULL, -- 教师编号
                             `username` varchar(32) NOT NULL, -- 用户名
                             `password` varchar(32) NOT NULL, -- 密码
                             `clazz_id` int(5) NOT NULL, -- 班级ID
                             `sex` varchar(5) NOT NULL DEFAULT '男', -- 性别
                             `mobile` varchar(12) DEFAULT NULL, -- 手机号码
                             `qq` varchar(18) DEFAULT NULL, -- QQ号码
                             `photo` varchar(255) DEFAULT NULL, -- 照片
                             PRIMARY KEY (`id`,`sn`),
                             KEY `student_clazz_id_foreign` (`clazz_id`),
                             CONSTRAINT `s_teacher_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `s_clazz` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 向s_teacher表插入数据
insert into `s_teacher`(`id`,`sn`,`username`,`password`,`clazz_id`,`sex`,`mobile`,`qq`,`photo`) values (9,'T11528608730648','张三','111',4,'男','13918655656','1193284480',NULL),(10,'T11528609224588','李四老师','111',4,'男','13656565656','123456',NULL),(11,'T51528617262403','李老师','123456',5,'男','18989898989','1456655565',NULL),(18,'T11561727746515','夏青松','123456',1,'女','15174857845','1745854125','5d447b8b-ec54-4a8e-919a-453aa7b6d33b.jpg');


-- 恢复默认设置
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET SQL_NOTES=@OLD_SQL_NOTES;
