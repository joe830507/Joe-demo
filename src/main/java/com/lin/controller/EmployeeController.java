package com.lin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.constant.CommonConstant;
import com.lin.dto.ApiResponse;
import com.lin.dto.EmployeeCreationDto;
import com.lin.enums.EmployeeActionEnum;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

	@PostMapping(produces = CommonConstant.JSON_UTF8)
	public ResponseEntity<ApiResponse> addNewEmployee(@RequestBody EmployeeCreationDto empCreationDto) {
		EmployeeActionEnum CREATED = EmployeeActionEnum.CREATED;
		return ResponseEntity.ok(new ApiResponse(CREATED.getCode(), CREATED.getMessage()));
	}
}
