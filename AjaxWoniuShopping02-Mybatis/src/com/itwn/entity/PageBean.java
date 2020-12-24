package com.itwn.entity;

import java.util.List;

public class PageBean<T> {
    private List<T> list;//分页的结果集
    private int maxPage;//最后一页

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getMaxPage() {
        return maxPage;
    }
}
