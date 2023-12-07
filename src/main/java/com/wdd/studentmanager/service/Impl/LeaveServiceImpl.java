package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.Leave;
import com.wdd.studentmanager.mapper.LeaveMapper;
import com.wdd.studentmanager.service.LeaveService;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname LeaveServiceImpl
 * @Description 实现了 LeaveService 接口的服务类，用于管理请假相关操作
 * @Date 2023/12/2 15:54
 * @Created
 */
@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveMapper leaveMapper;

    /**
     * 构造函数，注入LeaveMapper
     * @param leaveMapper 请假数据映射器
     */
    public LeaveServiceImpl(LeaveMapper leaveMapper) {
        this.leaveMapper = leaveMapper;
    }

    /**
     * 分页查询请假数据
     * @param paramMap 包含分页和查询参数的Map
     * @return 包含请假数据的分页对象
     */
    @Override
    public PageBean<Leave> queryPage(Map<String, Object> paramMap) {
        PageBean<Leave> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<Leave> datas = leaveMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = leaveMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * 添加请假记录
     * @param leave 请假对象
     * @return 插入操作的结果（影响的行数）
     */
    @Override
    public int addLeave(Leave leave) {
        return leaveMapper.addLeave(leave);
    }

    /**
     * 编辑请假记录
     * @param leave 请假对象
     * @return 更新操作的结果（影响的行数）
     */
    @Override
    public int editLeave(Leave leave) {
        return leaveMapper.editLeave(leave);
    }

    /**
     * 审核请假记录
     * @param leave 请假对象
     * @return 审核操作的结果（影响的行数）
     */
    @Override
    public int checkLeave(Leave leave) {
        return leaveMapper.checkLeave(leave);
    }

    /**
     * 删除指定ID的请假记录
     * @param id 请假记录ID
     * @return 删除操作的结果（影响的行数）
     */
    @Override
    public int deleteLeave(Integer id) {
        return leaveMapper.deleteLeave(id);
    }
}
