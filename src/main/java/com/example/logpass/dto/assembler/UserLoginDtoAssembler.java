package com.example.logpass.dto.assembler;

import com.example.logpass.dto.UserLoginDto;
import jakarta.servlet.http.HttpServletRequest;

public class UserLoginDtoAssembler {
    public UserLoginDto assemble(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return new UserLoginDto(email, password);
    }
}
