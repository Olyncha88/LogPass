package com.example.logpass.controller;

import com.example.logpass.dto.UserRegisterDto;
import com.example.logpass.dto.mapper.UserMapper;
import com.example.logpass.enteties.User;
import com.example.logpass.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registration", value = "/register")
public class RegistrationController extends HttpServlet {

    private UserService service;
    private UserMapper mapper;

    @Override
    public void init() {
        service = new UserService();
        mapper = new UserMapper();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = mapper.toUser((UserRegisterDto) request.getAttribute("user"));
        service.save(user);
        request.setAttribute("color", "green");
        request.setAttribute("message", "User is registered!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        service = null;
        mapper = null;
    }
}



