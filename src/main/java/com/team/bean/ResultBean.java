package com.team.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 6555201656989268527L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int CHECK_FAIL = 1;

    public static final int NO_PERMISSION = 2;

    public static final int UNKNOWN_EXCEPTION = -99;

    
    


	/**
     * 返回的信息（出错时使用）
     */
    private String msg = "success";

    /**
     * 接口返回码
     * 0 ： 成功
     * >0 ： 表示已知异常 （需要调用地方单独处理）
     * <0 : 表示未知异常 (不需要单独处理)
     */
    private int code = SUCCESS;

    
    // 临时编写 get set
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
    public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = UNKNOWN_EXCEPTION;
    }
}
