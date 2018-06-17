package com.zhbit.comparator;

import com.zhbit.entity.Menu;

import java.util.Comparator;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:16:39 描述：
 */
public class MenuComparator implements Comparator<Menu> {
    public int compare(Menu o1, Menu o2) {
        int i1 = o1.getCseq() != null ? o1.getCseq().intValue() : -1;
        int i2 = o2.getCseq() != null ? o2.getCseq().intValue() : -1;
        return i1 - i2;
    }
}
