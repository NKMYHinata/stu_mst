package com.wdd.studentmanager.service.Impl;

import com.wdd.studentmanager.domain.Score;
import com.wdd.studentmanager.domain.ScoreStats;
import com.wdd.studentmanager.mapper.ScoreMapper;
import com.wdd.studentmanager.service.ScoreService;
import com.wdd.studentmanager.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname ScoreServiceImpl
 * @Description 实现了 ScoreService 接口的服务类，用于管理成绩相关操作
 * @Date 2023/12/3 11:45
 * @Created
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;

    /**
     * 构造函数，注入ScoreMapper
     * @param scoreMapper 成绩数据映射器
     */
    public ScoreServiceImpl(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    /**
     * 分页查询成绩数据
     * @param paramMap 包含分页和查询参数的Map
     * @return 包含成绩数据的分页对象
     */
    @Override
    public PageBean<Score> queryPage(Map<String, Object> paramMap) {
        PageBean<Score> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<Score> datas = scoreMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = scoreMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * 检查是否已有成绩记录
     * @param score 成绩对象
     * @return 若已有记录则返回true，否则返回false
     */
    @Override
    public boolean isScore(Score score) {
        Score sc = scoreMapper.isScore(score);
        return sc != null;
    }

    /**
     * 添加成绩
     * @param score 成绩对象
     * @return 插入操作的结果（影响的行数）
     */
    @Override
    public int addScore(Score score) {
        return scoreMapper.addScore(score);
    }

    /**
     * 编辑成绩信息
     * @param score 成绩对象
     * @return 更新操作的结果（影响的行数）
     */
    @Override
    public int editScore(Score score) {
        return scoreMapper.editScore(score);
    }

    /**
     * 删除指定ID的成绩
     * @param id 成绩记录ID
     * @return 删除操作的结果（影响的行数）
     */
    @Override
    public int deleteScore(Integer id) {
        return scoreMapper.deleteScore(id);
    }

    /**
     * 获取所有成绩记录
     * @param score 成绩筛选条件
     * @return 成绩列表
     */
    @Override
    public List<Score> getAll(Score score) {
        return scoreMapper.getAll(score);
    }

    /**
     * 获取指定课程的平均成绩统计
     * @param courseid 课程ID
     * @return 成绩统计数据
     */
    @Override
    public ScoreStats getAvgStats(Integer courseid) {
        return scoreMapper.getAvgStats(courseid);
    }
}
