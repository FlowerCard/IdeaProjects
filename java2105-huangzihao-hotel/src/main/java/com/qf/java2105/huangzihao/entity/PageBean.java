package com.qf.java2105.huangzihao.entity;

import java.util.List;

/**
 * 分页实体
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public class PageBean<T> {

    /**
     * 集合
     */
    private List<T> beanList;

    /**
     * 当前页
     */
    private Integer currentPage = 1;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总数量
     */
    private Long totalCount;

    /**
     * 页大小
     */
    private Integer pageSize = 1;

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (0 >= currentPage) {
            //判断传入的当前页是否合理
            this.currentPage = 1;
        } else {
            if (currentPage <= this.totalPage) {
                //判断传入的当前页是否超过最大页数
//                this.currentPage = this.totalPage;
                this.currentPage = currentPage;
            } else {
                this.currentPage = this.totalPage;
            }
        }
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        int count = this.totalCount.intValue();
        if (count % this.pageSize == 0) {
            //如果总数可以整除页大小，总页数就为 总量 / 页大小 的 商 
            this.totalPage = count / this.pageSize;
        } else {
            //如果总数不可以整除页大小，总页数就为 总量 / 页大小 + 1
            this.totalPage = count/ this.pageSize + 1;
        }
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        //判断传入的页大小是否合理
        if (0 >= pageSize || null == pageSize) {
            //当pageSize小于等于0时，或者pageSize传入为空时 设置为1
            this.pageSize = 1;
        } else {
            //当页大小大于0时 设置为传入的值
            this.pageSize = pageSize;
        }
    }
}
