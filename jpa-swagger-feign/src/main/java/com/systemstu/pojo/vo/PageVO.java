package com.systemstu.pojo.vo;

import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/16 9:56
 */
public class PageVO<T> {
    private List<T> content;
    private Long total;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public PageVO() {
    }
}
