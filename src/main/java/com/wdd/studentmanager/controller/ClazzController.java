package com.wdd.studentmanager.controller;

import com.wdd.studentmanager.domain.Clazz;
import com.wdd.studentmanager.service.ClazzService;
import com.wdd.studentmanager.service.StudentService;
import com.wdd.studentmanager.util.AjaxResult;
import com.wdd.studentmanager.util.Data;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Classname ClazzController
 * @Description 班级管理
 * @Date 2023/11/26 9:08
 * @Created
 */
@Controller
@RequestMapping("/clazz")
public class ClazzController {
    private final ClazzService clazzService;
    private final StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(SelectedCourseController.class);

    public ClazzController(ClazzService clazzService, StudentService studentService) {
        this.clazzService = clazzService;
        this.studentService = studentService;
    }


    /**
     * 跳转班级页面
     * @return
     */
    @GetMapping("/clazz_list")
    public String clazzList(){
        return "/clazz/clazzList";
    }

    /**
     * 异步加载班级列表
     * @param page
     * @param rows
     * @param clazzName
     * @return
     */
    @PostMapping("/getClazzList")
    @ResponseBody
    public Object getClazzList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows, String clazzName, String from){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!StringUtils.isEmpty(clazzName))  paramMap.put("name",clazzName);
        PageBean<Clazz> pageBean = clazzService.queryPage(paramMap);
        if(!StringUtils.isEmpty(from) && from.equals("combox")){
            return pageBean.getDatas();
        }else{
            Map<String,Object> result = new HashMap<>();
            result.put("total",pageBean.getTotalsize());
            result.put("rows",pageBean.getDatas());
            return result;
        }
    }

    /**
     * 添加班级
     * @param clazz
     * @return
     */
    @PostMapping("/addClazz")
    @ResponseBody
    public AjaxResult addClazz(Clazz clazz){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = clazzService.addClazz(clazz);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("添加成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("添加失败");
            }
        }catch (Exception e){
            logger.error("Add Clazz Error: ", e);
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加错误");
        }
        return ajaxResult;
    }

    /**
     * 删除班级
     * @param data
     * @return
     */
    @PostMapping("/deleteClazz")
    @ResponseBody
    public AjaxResult deleteClazz(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            List<Integer> ids = data.getIds();
            Iterator<Integer> iterator = ids.iterator();
            while (iterator.hasNext()){  //判断是否存在课程关联学生
                if(!studentService.isStudentByClazzId(iterator.next())){
                    ajaxResult.setSuccess(false);
                    ajaxResult.setMessage("删除失败！该班级存在学生，请清除学生后再删除班级！");
                    return ajaxResult;
                }
            }
            int count = clazzService.deleteClazz(data.getIds());
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("删除成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("删除失败");
            }
        }catch (Exception e){
            logger.error("Delete Clazz Error: ", e);
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("删除失败！该班级存在老师或学生，请清除学生后再删除班级！");
        }
        return ajaxResult;
    }

    /**
     * 班级修改
     * @param clazz
     * @return
     */
    @PostMapping("/editClazz")
    @ResponseBody
    public AjaxResult editClazz(Clazz clazz){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = clazzService.editClazz(clazz);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("修改成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("修改失败");
            }
        }catch (Exception e){
            logger.error("Edit Clazz Error: ", e);
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改错误");
        }
        return ajaxResult;
    }
}
