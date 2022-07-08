package com.example.logpass.controller;


import com.example.logpass.dto.UserLoginDto;
import com.example.logpass.dto.mapper.UserMapper;
import com.example.logpass.enteties.User;
import com.example.logpass.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private UserService service;
    private UserMapper mapper;

    @Override
    public void init() {
        logger.trace("{}init.",this.getClass());
        service = new UserService();
        mapper = new UserMapper();
        logger.trace("{} init.", this.getClass());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/users";
        User user = mapper.toUser((UserLoginDto) request.getAttribute("user"));
        logger.debug("Get users");
        HttpSession session = request.getSession();
        /*
        boolean isRegistered = service.isRegistered(user);
        session.setAttribute("isAuth", isRegistered);

        if(!isRegistered){
            logger.warn("! not registered");
            request.setAttribute("color", "red");
            request.setAttribute("message", "User not registered!");
            path = "index.jsp";
        }*/
        logger.debug("Move to {} url for user {}", path, user);
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    public void destroy() {
        service = null;
        mapper = null;
    }
}
