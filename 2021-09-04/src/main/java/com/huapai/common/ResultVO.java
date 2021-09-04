package com.huapai.common;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/4.
 */
public class ResultVO implements Serializable {
    private static final long serialVersionUID = -1419552696725119340L;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 附加数据
     */
    private Object data;

    /**
     * 成功，无附加数据
     * @param message 提示信息
     * @return ResultVO
     */
    public static ResultVO ok(String message) {
        return new ResultVO(true,message);
    }

    /**
     * 成功，有附加数据
     * @param message 提示信息
     * @param data 附加数据
     * @return ResultVO
     */
    public static ResultVO ok(String message, Object data) {
        return new ResultVO(true,message,data);
    }

    /**
     * 失败，无附加数据
     * @param message 提示信息
     * @return ResultVO
     */
    public static ResultVO fail(String message) {
        return new ResultVO(false,message);
    }

    /**
     * 失败，有附加数据
     * @param message 提示信息
     * @param data 附加数据
     * @return ResultVO
     */
    public static ResultVO fail(String message, Object data) {
        return new ResultVO(false,message,data);
    }

    public ResultVO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultVO(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
