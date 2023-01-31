package com.lin.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.app.DemoApplication;
import com.lin.dto.ApiResponse;
import com.lin.dto.EmployeeCreationDto;

@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void successfully_add_new_employee() throws Exception {
		String account = "firstEmployee";
		String password = "firstEmployee";
		String email = "firstEmployee@";
		String name = "Larry James";
		Date birthday = giveBirthdate();
		Integer roleId = 0;
		EmployeeCreationDto empCreationDto = new EmployeeCreationDto(account, password, email, name, birthday, roleId);

		RequestBuilder rb = empCreationRequest(empCreationDto);
		String responseObj = mockMvc.perform(rb).andExpect(status().isOk())
				.andExpect(content().json(employee_created_response())).andReturn().getResponse().getContentAsString();
		assertThat(responseObj).contains("員工新增成功");

	}

	private String employee_created_response() throws JsonProcessingException {
		return objectMapper.writeValueAsString(new ApiResponse(1002, "員工新增成功"));
	}

	private Date giveBirthdate() {
		LocalDateTime ldt = LocalDateTime.of(1990, 3, 20, 0, 0);
		Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}

	private RequestBuilder empCreationRequest(EmployeeCreationDto empCreationDto) throws JsonProcessingException {
		return MockMvcRequestBuilders.post(URI.create("/employee")).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(empCreationDto));
	}

}
