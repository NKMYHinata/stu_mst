package com.wdd.studentmanager.controller;

import com.wdd.studentmanager.domain.SelectedCourse;
import com.wdd.studentmanager.domain.Student;
import com.wdd.studentmanager.service.SelectedCourseService;
import com.wdd.studentmanager.util.AjaxResult;
import com.wdd.studentmanager.util.Const;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname SelectedCourseController
 * @Description 选课信息控制器
 * @Date 2023/11/30 10:39
 * @Created
 */
@Controller
@RequestMapping("/selectedCourse")
public class SelectedCourseController {

    private final SelectedCourseService selectedCourseService;
    private static final Logger logger = LoggerFactory.getLogger(SelectedCourseController.class);

    public SelectedCourseController(SelectedCourseService selectedCourseService){
        this.selectedCourseService=selectedCourseService;
    }


    // 选课常量
    private static final int COURSE_ADD_SUCCESS = 1;
    private static final int COURSE_FULL = 0;
    private static final int COURSE_ALREADY_SELECTED = 2;



    @GetMapping("/selectedCourse_list")
    public String selectedCourseList(){
        return "course/selectedCourseList";
    }

    /**
     * 异步加载选课信息列表
     * @param page
     * @param rows
     * @param studentid
     * @param courseid
     * @param from
     * @return
     */
    @PostMapping("/getSelectedCourseList")
    @ResponseBody
    public Object getClazzList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                               @RequestParam(value = "teacherid", defaultValue = "0")String studentid,
                               @RequestParam(value = "teacherid", defaultValue = "0")String courseid ,String from,HttpSession session){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!studentid.equals("0"))  paramMap.put("studentId",studentid);
        if(!courseid.equals("0"))  paramMap.put("courseId",courseid);
        //判断是老师还是学生权限
        Student student = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student)){
            //是学生权限，只能查询自己的信息
            paramMap.put("studentid",student.getId());
        }
        PageBean<SelectedCourse> pageBean = selectedCourseService.queryPage(paramMap);
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
     * 学生进行选课
     * @param selectedCourse
     * @return
     */
    @PostMapping("/addSelectedCourse")
    @ResponseBody
    public AjaxResult addSelectedCourse(SelectedCourse selectedCourse){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = selectedCourseService.addSelectedCourse(selectedCourse);
            if(count == COURSE_ADD_SUCCESS){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("选课成功");
            }else if(count == COURSE_FULL){
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("选课人数已满");
            }else if(count == COURSE_ALREADY_SELECTED){
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("已选择这门课程");
            }
        }catch (Exception e){
            logger.error("Add Select Course", e);
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("系统内部出错，请联系管理员!");
        }
        return ajaxResult;
    }

    /**
     * 删除选课信息
     * @param id
     * @return
     */
    @PostMapping("/deleteSelectedCourse")
    @ResponseBody
    public AjaxResult deleteSelectedCourse(Integer id){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = selectedCourseService.deleteSelectedCourse(id);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("移除成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("移除失败");
            }
        } catch (Exception e) {
            logger.error("Delete Selected Course Error: ", e);
        }
        return ajaxResult;
    }
}
