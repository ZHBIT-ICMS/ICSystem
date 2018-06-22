package com.zhbit.util;

import java.util.ResourceBundle;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/10
 * @Time:15:54
 * 描述：
 * 获取config.properties
 */
public class ResourceUtil {
    private static final ResourceBundle bundle=ResourceBundle.getBundle("config");
    private void ResourceUtil(){

    }
    /**
     * 获得sessionInfo名字
     *
     * @return
     */
    public static final String getSessionInfoName() {
        return bundle.getString("sessionInfoName");
       // return "sessionInfo";
    }

    /**
     * 获得上传表单域的名称
     *
     * @return
     */
    public static final String getUploadFieldName() {
        return bundle.getString("uploadFieldName");
    }

    /**
     * 获得上传文件的最大大小限制
     *
     * @return
     */
    public static final long getUploadFileMaxSize() {
        return Long.valueOf(bundle.getString("uploadFileMaxSize"));
    }

    /**
     * 获得允许上传文件的扩展名
     *
     * @return
     */
    public static final String getUploadFileExts() {
        return bundle.getString("uploadFileExts");
    }

    /**
     * 获得上传文件要放到那个目录
     *
     * @return
     */
    public static final String getUploadDirectory() {
        return bundle.getString("uploadDirectory");
    }

    /**
     * 获取政策法规上传目录
     * @return
     */
    public static final String getPolicyUploadDirectory(){

        return bundle.getString("uploadPolicyDirectory");
    }

    /**
     * 获取新闻上传目录
     * @return
     */
    public static final String getNewsUploadDirectory(){
        return bundle.getString("uploadNewsDirectory");
    }

    /**
     * 获得通知公告上传目录
     * @return
     */
    public static  final String getNoticeUploadDirectory(){
        return bundle.getString("uploadNoticeDirectory");
    }

    /**
     * 获得协议上传目录
     * @return
     */
    public static  final String getAgreementUploadDirectory(){
        return bundle.getString("uploadAgreementDirectory");
    }
    /**
     *
     * @param args
     */
   public static void main(String []args){

       System.out.println("sessionInfoName:"+getSessionInfoName());
       System.out.println("协议上传："+getAgreementUploadDirectory());
   }
}
