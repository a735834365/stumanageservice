package com.team.base;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * API 格式封装
 * create by yifeng
 */
public class ApiResponse {

    private int code; // 标准状态码
    private String message;
    private Object data;
    private boolean more; // 数据集是否还有更多的信息




    public enum Status {
        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "");


        private int code;
        private String stadarMessage;

        Status(int code, String standarMessage) {
            this.code = code;
            this.stadarMessage = standarMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStadarMessage() {
            return stadarMessage;
        }

        public void setStadarMessage(String stadarMessage) {
            this.stadarMessage = stadarMessage;
        }
    }

}
