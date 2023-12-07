package com.wdd.studentmanager.service;

import com.wdd.studentmanager.domain.Admin;

/**
 * @Classname AdminService
 * @Description None
 * @Date 2023/11/25 11:07
 * @Created
 */
public interface AdminService {
    Admin findByAdmin(Admin admin);

    int editPswdByAdmin(Admin admin);
}
