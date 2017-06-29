package com.xuan.crow.common.result;

/**
 * 分页对象
 * <p>
 * Created by xuan on 17/3/19.
 */
public class Page {
    private int page;//当前页
    private int nextPage;//下一页
    private int pageSize;//每页条数
    private int totalCount;//总记录数
    private int totalPages;//总页数

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
