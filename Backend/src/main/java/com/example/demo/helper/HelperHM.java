package com.example.demo.helper;

public class HelperHM {
	private String message;
	private Object data;
	public HelperHM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HelperHM(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
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
		return "HelperHM [message=" + message + ", data=" + data + "]";
	}
	

}
