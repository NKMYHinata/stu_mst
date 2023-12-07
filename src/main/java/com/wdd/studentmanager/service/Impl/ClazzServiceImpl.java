package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.Clazz;
import com.wdd.studentmanager.mapper.ClazzMapper;
import com.wdd.studentmanager.service.ClazzService;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Classname ClazzServiceImpl
 * @Description 实现了 ClazzService 接口的服务类，用于管理班级相关操作
 * @Date 2023/11/26 10:14
 * @Created
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    private final ClazzMapper clazzMapper;

    /**
     * 构造函数，注入ClazzMapper
     * @param clazzMapper 班级数据映射器
     */
    public ClazzServiceImpl(ClazzMapper clazzMapper) {
        this.clazzMapper = clazzMapper;
    }

    /**
     * 分页查询班级数据
     * @param paramMap 包含分页和查询参数的Map
     * @return 包含班级数据的分页对象
     */
    @Override
    public PageBean<Clazz> queryPage(Map<String, Object> paramMap) {
        PageBean<Clazz> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<Clazz> datas = clazzMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = clazzMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * 添加班级
     * @param clazz 班级对象
     * @return 插入操作的结果（影响的行数）
     */
    @Override
    public int addClazz(Clazz clazz) {
        return clazzMapper.addClazz(clazz);
    }

    /**
     * 删除班级
     * @param ids 要删除的班级ID列表
     * @return 删除操作的结果（影响的行数）
     */
    @Override
    @Transactional
    public int deleteClazz(List<Integer> ids) {
        return clazzMapper.deleteClazz(ids);
    }

    /**
     * 编辑班级信息
     * @param clazz 班级对象
     * @return 更新操作的结果（影响的行数）
     */
    @Override
    public int editClazz(Clazz clazz) {
        return clazzMapper.editClazz(clazz);
    }

    /**
     * 根据班级名称查找班级
     * @param clazzName 班级名称
     * @return 查找到的班级对象
     */
    @Override
    public Clazz findByName(String clazzName) {
        return clazzMapper.findByName(clazzName);
    }
}
