package com.lin.enums;

public enum EmployeeActionEnum {

	CREATED(1002, "員工新增成功");

	private Integer code;
	private String message;

	EmployeeActionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
