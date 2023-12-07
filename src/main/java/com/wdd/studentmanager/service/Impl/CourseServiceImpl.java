package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.Course;
import com.wdd.studentmanager.mapper.CourseMapper;
import com.wdd.studentmanager.service.CourseService;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname CourseServiceImpl
 * @Description 实现了 CourseService 接口的服务类，用于管理课程相关操作
 * @Date 2023/11/29 20:09
 * @Created
 */
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    /**
     * 构造函数，注入CourseMapper
     * @param courseMapper 课程数据映射器
     */
    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    /**
     * 分页查询课程数据
     * @param paramMap 包含分页和查询参数的Map
     * @return 包含课程数据的分页对象
     */
    @Override
    public PageBean<Course> queryPage(Map<String, Object> paramMap) {
        PageBean<Course> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<Course> datas = courseMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = courseMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * 添加课程
     * @param course 课程对象
     * @return 插入操作的结果（影响的行数）
     */
    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    /**
     * 编辑课程信息
     * @param course 课程对象
     * @return 更新操作的结果（影响的行数）
     */
    @Override
    public int editCourse(Course course) {
        return courseMapper.editCourse(course);
    }

    /**
     * 删除指定ID的课程
     * @param ids 要删除的课程ID列表
     * @return 删除操作的结果（影响的行数）
     */
    @Override
    public int deleteCourse(List<Integer> ids) {
        return courseMapper.deleteCourse(ids);
    }

    /**
     * 根据ID列表获取课程信息
     * @param ids 课程ID列表
     * @return 课程列表
     */
    @Override
    public List<Course> getCourseById(List<Integer> ids) {
        return courseMapper.getCourseById(ids);
    }

    /**
     * 根据课程名称查找课程
     * @param name 课程名称
     * @return 查找到的课程数目
     */
    @Override
    public int findByName(String name) {
        return courseMapper.findByName(name);
    }

}
