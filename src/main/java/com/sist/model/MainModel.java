package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainModel {

    @RequestMapping("main.do")
    public String main_page(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("main_jsp", "../main/home.jsp");
        return "../main/main.jsp";
    }
}
