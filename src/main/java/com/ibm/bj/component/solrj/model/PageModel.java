package com.ibm.bj.component.solrj.model;

import java.util.List;

/**
 * Created by zhengxiangyun on 2015/11/6.
 */

public class PageModel {

    public static final int DEFAULT_SIZE = 10;

    private int current;

    private int size;

    private long count;

    private long totalPages;

    private String parameter;

    private List<FileModel> datas;

    public PageModel() {
        current = 1;            
        size = DEFAULT_SIZE;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public List<FileModel> getDatas() {
        return datas;
    }


    public void setDatas(List<FileModel> datas) {
        this.datas = datas;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getTotalPages() {
        if (datas == null || datas.isEmpty())
            return 0;

        long totalPages = count / size;
        if (count%size != 0) {
            totalPages ++;
        }

        return totalPages;
    }

    public long getStart() {
        return (current-1) * size;
    }

    public boolean getHasPrevious() {
        return current == 1 ? false : true;
    }

    public boolean getHasNext() {
        return (getTotalPages()!=0 && getTotalPages()!=current) ? true : false;
    }

}
