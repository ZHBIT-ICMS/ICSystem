package com.zhbit.util;



import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/10
 * @Time:16:27
 * 描述：
 * 返回错误信息字符串工具类
 */
public class ExceptionUtil {
   // private static final Logger logger = Logger.getLogger(ExceptionUtil.class);

    /**
     *
     *
     * @param ex
     *            Exception
     * @return 错误信息字符串
     */
    public static String getExceptionMessage(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String errorMessage = sw.toString();
        pw.close();
        try {
            sw.close();
        } catch (IOException e) {
            //logger.error(e);
            e.printStackTrace();
        }
        return errorMessage;
    }
}
