package net.xzclass.xzvideo.model;

import java.io.Serializable;

public class JsonData implements Serializable {

	private static final long serialVersionUID = -6273714967254125032L;

	/**
	 * 状态码
	 * 0 表示成功，1表示处理中，-1表示失败
	 */
	private Integer code;
	
	/**
	 * 数据
	 */
	private Object data;
	
	/**
	 * 描述
	 */
	private String msg;

	public JsonData(Integer code, Object data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public JsonData() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static JsonData buildSuccess() {
		return new JsonData(0, null, null);
	}
	
	public static JsonData buildSuccess(Object data) {
		return new JsonData(0, data, null);
	}
	
	public static JsonData buildSuccess(Integer code, Object data) {
		return new JsonData(code, data, null);
	}
	
	public static JsonData buildError(String msg) {
		return new JsonData(-1, null, msg);
	}
	
	public static JsonData buildError(Integer code, String msg) {
		return new JsonData(code, null, msg);
	}
	
	public String toString() {
		return "JsonData [code=" + code + ", data=" + data + ", msg=" + msg + "]";
	}
}
