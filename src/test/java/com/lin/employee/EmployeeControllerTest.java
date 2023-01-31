package com.lin.employee;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import ch.qos.logback.core.status.Status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void successfully_add_new_employee() {
        String account = "firstEmployee";
        String password = "firstEmployee";
        String email = "firstEmployee@";
        String name = "Larry James";
        Date birthday = giveBirthdate();
        Integer roleId = 0;
        EmployeeCreationDto empCreationDto = new EmployeeCreationDto(account, password, email, name, birthday, roleId);

        RequestBuilder rb = empCreationRequest(empCreationDto);
        mockMvc.perform(rb).andExpect(status());

    }

    private Date giveBirthdate() {
        LocalDateTime ldt = LocalDateTime.of(1990, 3, 20, 0, 0);
        Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
