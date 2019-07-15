package com.ssm.pojo;

import java.util.List;

public class PageBean<T> {

    private int conutpage;
    private int pagesize;
    private int total;
    private int pageaCont;
    private List <T> data;

    @Override
    public String toString() {
        return "PageBean{" +
                "conutpage=" + conutpage +
                ", pagesize=" + pagesize +
                ", total=" + total +
                ", pageaCont=" + pageaCont +
                ", data=" + data +
                '}';
    }

    public int getConutpage() {
        return conutpage;
    }

    public void setConutpage(int conutpage) {
        this.conutpage = conutpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageaCont() {
        return pageaCont;
    }

    public void setPageaCont(int pageaCont) {
        this.pageaCont = pageaCont;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageBean() {
    }
}
