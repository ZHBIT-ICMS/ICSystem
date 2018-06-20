package com.zhbit.exception;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/8
 * @Time:23:11 描述：
 */
public class ValidateFieldsException extends BusinessException {

    /**
     *
     */
    private static final long serialVersionUID = -2413829008330222820L;

    public ValidateFieldsException() {
    }

    public ValidateFieldsException(Throwable cause) {
        super(cause);
    }

    public ValidateFieldsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateFieldsException(String message) {
        super(message);
    }

    public ValidateFieldsException(String message, String[]args) {
        super(message, args);
    }

    public ValidateFieldsException(String message, String[]args, Throwable cause) {
        super(message, args, cause);
    }
}
