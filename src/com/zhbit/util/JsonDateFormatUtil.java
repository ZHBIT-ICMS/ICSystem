package com.zhbit.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/10
 * @Time:16:56
 * 描述：将Date类型转换成String类型
 */
public class JsonDateFormatUtil implements JsonValueProcessor {
    private String datePattern="yyyy-MM-dd";
    public  JsonDateFormatUtil(){
        super();
    }
    public JsonDateFormatUtil(String format){
        super();
        if(format!=null&&format.length()!=0){
            this.datePattern=format;
        }
    }
    @Override
    public  Object processArrayValue(Object value, JsonConfig jsonConfig){
        return process(value);
    }
    @Override
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return process(value);
    }
    //用于格式化date类型的值
    private Object process(Object value) {
        try {
            if (value instanceof Date) {
                SimpleDateFormat sdf = new SimpleDateFormat(datePattern,
                        Locale.CHINESE);
                return sdf.format((Date) value);
            }
            return value == null ? "" : value.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     *
     * @return
     */
    public String getDatePattern() {
        return datePattern;
    }

    /**
     *
     * @param datePattern
     */
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
