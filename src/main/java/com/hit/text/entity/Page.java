package com.hit.text.entity;

/**
 * 封装分页的功能
 * @author yang
 * @create 2021-09-08 21:44
 */
public class Page {
    // 当前页码
    private int current = 1;
    // 显示上限
    private int limit = 10;
    // 数据总数（用于计算总页数）
    private int rows;
    // 查询路径（用于复用分页的连接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit > 0 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * 第一页的offset从0开始
     * @return
     */
    public int getOffset(){
        // current * limit - limit
        return (current-1)*limit;
    }

    /**
     * 获取总页码
     * @return
     */
    public int getTotal(){
        return rows%limit==0?rows/limit:(rows/limit+1);
    }

    /**
     * 当前页面的页码从哪个页码开始
     * @return
     */
    public int getFrom(){
        return current-2<=1?1:current-2;
    }

    /**
     * 当前页面的页码从哪个页码结束
     * @return
     */
    public int getTo(){
        int to=current+2;
        int total = getTotal();
        return to>total?total:to;
    }

}
