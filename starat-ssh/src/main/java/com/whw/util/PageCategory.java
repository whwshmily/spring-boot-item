package com.whw.util;

import lombok.Data;

import java.util.List;

@Data
public class PageCategory<T> {
    private static final int pageSize = 10;
    private int totalPage;
    private int pageNumber;
    private int start;
    private int end;
    private boolean hasPrev;
    private boolean hasNext;
    private List<T> list;

    public static int pageStart(int pageNumber) {
        return (pageNumber - 1) * pageSize;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public boolean isHasPrev() {
        if (pageNumber <= 1) {
            return false;
        }
        return true;
    }

    public boolean isHasNext() {
        if (pageNumber >= totalPage) {
            return false;
        }
        return true;
    }

    public static <T> PageCategory<T> startPage(int pageNumber, int count) {
        PageCategory<T> page = new PageCategory<T>();
        page.setPageNumber(pageNumber);
        page.totalPage = totalPage(count);
        page.handle();
        return page;
    }

    public static int totalPage(int total) {

        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

    public void handle() {
//        if (pageNumber >= totalPage) {
//            pageCategory.setStart(totalPage - 9);
//            pageCategory.setEnd(totalPage);
//        } else {
        if (pageNumber > totalPage) pageNumber = totalPage;
        if (pageNumber <= 1) pageNumber = 1;
        this.setPageNumber(pageNumber);
        if (totalPage <= 10) {
            this.setStart(1);
            this.setEnd(totalPage);
        } else {
            int temp = totalPage - pageNumber;
            if (temp < 4) {
                this.setStart(totalPage - 9);
                this.setEnd(totalPage);
            } else {
                if (pageNumber <= 5) {
                    this.setStart(1);
                    this.setEnd(10);
                } else {
                    this.setStart(pageNumber - 5);
                    this.setEnd(pageNumber + 4);
                }
            }
        }
    }
}
//}
