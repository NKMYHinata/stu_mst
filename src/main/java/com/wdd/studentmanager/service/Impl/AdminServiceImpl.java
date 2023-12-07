package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.Admin;
import com.wdd.studentmanager.mapper.AdminMapper;
import com.wdd.studentmanager.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @Classname AdminServiceImpl
 * @Description 实现了 AdminService 接口的服务类，用于管理Admin实体的相关操作
 * @Date 2023/11/25 11:08
 * @Created
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    /**
     * 构造函数，注入AdminMapper
     * @param adminMapper 管理员数据映射器
     */
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 根据Admin对象查找相应的Admin信息
     * @param admin 管理员对象
     * @return 查找到的管理员对象
     */
    @Override
    public Admin findByAdmin(Admin admin) {
        return adminMapper.findByAdmin(admin);
    }

    /**
     * 根据Admin对象更新密码
     * @param admin 管理员对象
     * @return 更新操作的结果，即为影响的行数
     */
    @Override
    public int editPswdByAdmin(Admin admin) {
        return adminMapper.editPswdByAdmin(admin);
    }
}
