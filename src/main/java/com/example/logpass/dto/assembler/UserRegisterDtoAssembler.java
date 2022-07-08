package com.example.logpass.dto.assembler;

import com.example.logpass.dto.UserRegisterDto;
import jakarta.servlet.http.HttpServletRequest;

public class UserRegisterDtoAssembler {
    public UserRegisterDto assemble(HttpServletRequest request){
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return new UserRegisterDto(name, login, email, password);
    }
}
