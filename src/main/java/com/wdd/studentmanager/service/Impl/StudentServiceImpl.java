package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.Student;
import com.wdd.studentmanager.mapper.StudenetMapper;
import com.wdd.studentmanager.service.StudentService;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudentServiceImpl
 * @Description 实现了 StudentService 接口的服务类，用于管理学生相关操作
 * @Date 2023/11/27 14:12
 * @Created
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudenetMapper studenetMapper;

    /**
     * 构造函数，注入StudenetMapper
     * @param studenetMapper 学生数据映射器
     */
    public StudentServiceImpl(StudenetMapper studenetMapper) {
        this.studenetMapper = studenetMapper;
    }

    /**
     * 分页查询学生数据
     * @param paramMap 包含分页和查询参数的Map
     * @return 包含学生数据的分页对象
     */
    @Override
    public PageBean<Student> queryPage(Map<String, Object> paramMap) {
        PageBean<Student> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<Student> datas = studenetMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = studenetMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * 删除指定ID的学生
     * @param ids 要删除的学生ID列表
     * @return 删除操作的结果（影响的行数）
     */
    @Override
    public int deleteStudent(List<Integer> ids) {
        return studenetMapper.deleteStudent(ids);
    }

    /**
     * 添加学生
     * @param student 学生对象
     * @return 插入操作的结果（影响的行数）
     */
    @Override
    public int addStudent(Student student) {
        return studenetMapper.addStudent(student);
    }

    /**
     * 根据ID查找学生
     * @param sid 学生ID
     * @return 查找到的学生对象
     */
    @Override
    public Student findById(Integer sid) {
        return studenetMapper.findById(sid);
    }

    /**
     * 编辑学生信息
     * @param student 学生对象
     * @return 更新操作的结果（影响的行数）
     */
    @Override
    public int editStudent(Student student) {
        return studenetMapper.editStudent(student);
    }

    /**
     * 根据学生对象查找学生
     * @param student 学生对象
     * @return 查找到的学生对象
     */
    @Override
    public Student findByStudent(Student student) {
        return studenetMapper.findByStudent(student);
    }

    /**
     * 检查指定班级ID的学生是否存在
     * @param id 班级ID
     * @return 若不存在则返回true，否则返回false
     */
    @Override
    public boolean isStudentByClazzId(Integer id) {
        List<Student> studentList = studenetMapper.isStudentByClazzId(id);
        return studentList.isEmpty();
    }

    /**
     * 通过学生对象更新密码
     * @param student 学生对象
     * @return 更新操作的结果（影响的行数）
     */
    @Override
    public int editPswdByStudent(Student student) {
        return studenetMapper.editPswdByStudent(student);
    }

    /**
     * 根据学生名称查找学生
     * @param name 学生姓名
     * @return 查找到的学生数目
     */
    @Override
    public int findByName(String name) {
        return studenetMapper.findByName(name);
    }
}
