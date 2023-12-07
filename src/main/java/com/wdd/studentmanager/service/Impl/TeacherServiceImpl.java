package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.Teacher;
import com.wdd.studentmanager.mapper.TeacherMapper;
import com.wdd.studentmanager.service.TeacherService;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherServiceImpl
 * @Description 实现了 TeacherService 接口的服务类，用于管理教师相关操作
 * @Date 2023/11/28 18:56
 * @Created
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;

    /**
     * 构造函数，注入TeacherMapper
     * @param teacherMapper 教师数据映射器
     */
    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    /**
     * 分页查询教师数据
     * @param paramMap 包含分页和查询参数的Map
     * @return 包含教师数据的分页对象
     */
    @Override
    public PageBean<Teacher> queryPage(Map<String, Object> paramMap) {
        PageBean<Teacher> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<Teacher> datas = teacherMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = teacherMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * 删除指定ID的教师
     * @param ids 要删除的教师ID列表
     * @return 删除操作的结果（影响的行数）
     */
    @Override
    public int deleteTeacher(List<Integer> ids) {
        return teacherMapper.deleteTeacher(ids);
    }

    /**
     * 添加教师
     * @param teacher 教师对象
     * @return 插入操作的结果（影响的行数）
     */
    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    /**
     * 根据ID查找教师
     * @param tid 教师ID
     * @return 查找到的教师对象
     */
    @Override
    public Teacher findById(Integer tid) {
        return teacherMapper.findById(tid);
    }

    /**
     * 编辑教师信息
     * @param teacher 教师对象
     * @return 更新操作的结果（影响的行数）
     */
    @Override
    public int editTeacher(Teacher teacher) {
        return teacherMapper.editTeacher(teacher);
    }

    /**
     * 根据教师对象查找教师
     * @param teacher 教师对象
     * @return 查找到的教师对象
     */
    @Override
    public Teacher findByTeacher(Teacher teacher) {
        return teacherMapper.findByTeacher(teacher);
    }

    /**
     * 通过教师对象更新密码
     * @param teacher 教师对象
     * @return 更新操作的结果（影响的行数）
     */
    @Override
    public int editPswdByTeacher(Teacher teacher) {
        return teacherMapper.editPswdByTeacher(teacher);
    }
}
