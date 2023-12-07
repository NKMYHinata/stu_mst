package com.wdd.studentmanager.util;

import java.util.List;

/**
 * 封装分页信息和数据
 * 包含页码，页数据数量，数据列表，总页数，总条数
 * 计算开始索引方法用于数据库分页查询
 */
public class PageBean<T> {
    private Integer pageno;    // 当前页码
    private Integer pagesize;  // 每页显示的条目数
    private List<T> datas;     // 当前页的数据列表
    private Integer totalno;   // 总页数
    private Integer totalsize; // 总条目数

    /**
     * 构造函数，初始化分页参数
     *
     * @param pageno   当前页码。小于等于0时默认为1
     * @param pagesize 每页条数。小于等于0时默认为10
     */
    public PageBean(Integer pageno, Integer pagesize) {
        this.pageno = (pageno <= 0) ? 1 : pageno;
        this.pagesize = (pagesize <= 0) ? 10 : pagesize;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Integer getTotalno() {
        return totalno;
    }

    public void setTotalno(Integer totalno) {
        this.totalno = totalno;
    }

    public Integer getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(Integer totalsize) {
        this.totalsize = totalsize;
    }

    /**
     * 查找分页查询的开始索引
     *
     * @return 开始位置索引
     */
    public Integer getStartIndex() {
        return (this.pageno - 1) * this.pagesize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageno=" + pageno +
                ", pagesize=" + pagesize +
                ", datas=" + datas +
                ", totalno=" + totalno +
                ", totalsize=" + totalsize +
                '}';
    }
}
