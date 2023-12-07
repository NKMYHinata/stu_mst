package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.Attendance;
import com.wdd.studentmanager.mapper.AttendanceMapper;
import com.wdd.studentmanager.service.AttendanceService;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname AttendanceServiceImpl
 * @Description 实现了 AttendanceService 接口的服务类，用于管理考勤相关操作
 * @Date 2023/12/1 15:47
 * @Created
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceMapper attendanceMapper;

    /**
     * 构造函数，注入AttendanceMapper
     * @param attendanceMapper 考勤数据映射器
     */
    public AttendanceServiceImpl(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }

    /**
     * 分页查询考勤数据
     * @param paramMap 包含分页和查询参数的Map
     * @return 包含考勤数据的分页对象
     */
    @Override
    public PageBean<Attendance> queryPage(Map<String, Object> paramMap) {
        PageBean<Attendance> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<Attendance> datas = attendanceMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = attendanceMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * 检查是否已有考勤记录
     * @param attendance 考勤对象
     * @return 若已有记录则返回true，否则返回false
     */
    @Override
    public boolean isAttendance(Attendance attendance) {
        Attendance at = attendanceMapper.isAttendance(attendance);
        return at != null;
    }

    /**
     * 添加考勤记录
     * @param attendance 考勤对象
     * @return 插入操作的结果（影响的行数）
     */
    @Override
    public int addAtendance(Attendance attendance) {
        return attendanceMapper.addAtendance(attendance);
    }

    /**
     * 删除指定ID的考勤记录
     * @param id 考勤记录ID
     * @return 删除操作的结果（影响的行数）
     */
    @Override
    public int deleteAttendance(Integer id) {
        return attendanceMapper.deleteAttendance(id);
    }
}
