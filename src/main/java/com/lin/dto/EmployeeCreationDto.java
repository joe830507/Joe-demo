package com.lin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeCreationDto {

	private String account;
	private String password;
	private String email;
	private String name;
	private Date birthday;
	private Integer roleId;
}
