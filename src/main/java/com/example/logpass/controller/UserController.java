package com.example.logpass.controller;


import com.example.logpass.dto.UserDto;
import com.example.logpass.dto.mapper.UserMapper;
import com.example.logpass.enteties.User;
import com.example.logpass.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "users", value = "/users")
public class UserController extends HttpServlet {

    private UserService service;
    private UserMapper mapper;

    @Override
    public void init() {
        service = new UserService();
        mapper = new UserMapper();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /*@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<User> users = service.getAll();
        List<UserDto> userDtoList = users.stream().map(mapper::toUserDto)
                .collect(Collectors.toList());
        request.setAttribute("users", userDtoList);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }*/

    @Override
    public void destroy() {
        service = null;
        mapper = null;
    }
}