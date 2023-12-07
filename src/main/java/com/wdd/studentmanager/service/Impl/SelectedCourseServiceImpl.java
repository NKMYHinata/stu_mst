package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.SelectedCourse;
import com.wdd.studentmanager.mapper.CourseMapper;
import com.wdd.studentmanager.mapper.SelectedCourseMapper;
import com.wdd.studentmanager.service.SelectedCourseService;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Classname SelectedCourseServiceImpl
 * @Description 实现了 SelectedCourseService 接口的服务类，用于管理选课相关操作
 * @Date 2023/11/30 10:48
 * @Created
 */
@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {

    private final SelectedCourseMapper selectedCourseMapper;
    private final CourseMapper courseMapper;

    /**
     * 构造函数，注入SelectedCourseMapper和CourseMapper
     * @param selectedCourseMapper 选课数据映射器
     * @param courseMapper 课程数据映射器
     */
    public SelectedCourseServiceImpl(SelectedCourseMapper selectedCourseMapper,
                                     CourseMapper courseMapper) {
        this.selectedCourseMapper = selectedCourseMapper;
        this.courseMapper = courseMapper;
    }

    /**
     * 分页查询选课数据
     * @param paramMap 包含分页和查询参数的Map
     * @return 包含选课数据的分页对象
     */
    @Override
    public PageBean<SelectedCourse> queryPage(Map<String, Object> paramMap) {
        PageBean<SelectedCourse> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<SelectedCourse> datas = selectedCourseMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = selectedCourseMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * 添加选课记录
     * @param selectedCourse 选课对象
     * @return 插入操作的结果（影响的行数）
     */
    @Override
    @Transactional
    public int addSelectedCourse(SelectedCourse selectedCourse) {
        SelectedCourse s = selectedCourseMapper.findBySelectedCourse(selectedCourse);
        if (StringUtils.isEmpty(s)) {
            int count = courseMapper.addStudentNum(selectedCourse.getCourseId());
            if (count == 1) {
                selectedCourseMapper.addSelectedCourse(selectedCourse);
                return count;
            }
            if (count == 0) {
                return count;
            }
        } else {
            return 2;
        }
        return 3;
    }

    /**
     * 删除选课记录
     * @param id 选课记录ID
     * @return 删除操作的结果（影响的行数）
     */
    @Override
    @Transactional
    public int deleteSelectedCourse(Integer id) {
        SelectedCourse selectedCourse = selectedCourseMapper.findById(id);
        courseMapper.deleteStudentNum(selectedCourse.getCourseId());
        return selectedCourseMapper.deleteSelectedCourse(id);
    }

    /**
     * 检查学生是否已选择课程
     * @param id 学生ID
     * @return 若未选择则返回true，否则返回false
     */
    @Override
    public boolean isStudentId(int id) {
        List<SelectedCourse> selectedCourseList = selectedCourseMapper.isStudentId(id);
        return selectedCourseList.isEmpty();
    }

    /**
     * 获取指定学生ID的所有选课记录
     * @param studentid 学生ID
     * @return 选课记录列表
     */
    @Override
    public List<SelectedCourse> getAllBySid(int studentid) {
        return selectedCourseMapper.getAllBySid(studentid);
    }
}
