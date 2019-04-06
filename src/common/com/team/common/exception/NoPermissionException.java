package com.team.common.exception;

/**
 * 无权限异常
 * create by yifeng
 */
public class NoPermissionException extends RuntimeException {

    public NoPermissionException() {
        super();
    }

    public NoPermissionException(String message) {
        super(message);
    }

    public NoPermissionException(Throwable cause) {
        super(cause);
    }

    public NoPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    protected NoPermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
