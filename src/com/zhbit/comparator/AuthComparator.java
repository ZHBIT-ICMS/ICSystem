package com.zhbit.comparator;

import com.zhbit.entity.Auth;

import java.util.Comparator;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:16:58
 * 描述：
 * Auth排序
 */
public class AuthComparator implements Comparator<Auth> {

    public int compare(Auth o1, Auth o2) {
        int i1 = o1.getCseq() != null ? o1.getCseq().intValue() : -1;
        int i2 = o2.getCseq() != null ? o2.getCseq().intValue() : -1;
        return i1 - i2;
    }

}