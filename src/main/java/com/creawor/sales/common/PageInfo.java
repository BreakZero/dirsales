package com.creawor.sales.common;

import java.util.List;

/**
 * Created by Zero on 2017/3/10.
 * 分页查询的封装响应结果
 */
public class PageInfo<T> {
    private int count;
    private List<T> rows;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
