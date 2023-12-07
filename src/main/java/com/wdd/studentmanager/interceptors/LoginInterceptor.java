package com.wdd.studentmanager.interceptors;

import com.wdd.studentmanager.domain.Admin;
import com.wdd.studentmanager.domain.Student;
import com.wdd.studentmanager.domain.Teacher;
import com.wdd.studentmanager.util.Const;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录拦截器
 * 用于拦截未登录的用户请求
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从session中获取管理员、教师、学生对象
        Admin user = (Admin)request.getSession().getAttribute(Const.ADMIN);
        Teacher teacher = (Teacher)request.getSession().getAttribute(Const.TEACHER);
        Student student = (Student)request.getSession().getAttribute(Const.STUDENT);

        // 判断是否有用户登录，如果有，放行
        if(!StringUtils.isEmpty(user) || !StringUtils.isEmpty(teacher) || !StringUtils.isEmpty(student)){
            return true;
        }

        // 未登录，重定向到登录页面
        response.sendRedirect(request.getContextPath() + "/system/login");
        return false;
    }
}
