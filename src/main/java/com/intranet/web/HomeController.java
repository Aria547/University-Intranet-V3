package com.intranet.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


import com.intranet.metier.*;
import com.intranet.entities.*;

@Controller

public class HomeController {

    @Autowired

    private IntranetMetierInterface intranetMetierInterface;
    
    @RequestMapping("login")

    public string doGet(Model model, HttpServletRequest request, HttpServletResponse response)
    {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) 
        { 
            for (int i = 0; i < cookies.length; i++) 
            {
                if (cookies[i].getName().equals("status")) 
                {
                    string status = cookies[i].getValue(); 
                } 
          } 
          
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        String status = request.getParameter("status");

        pseudo.setMaxAge(60 * 60);
        password.setMaxAge(60 * 60);
        status.setMaxAge(60 * 60);

        Cookie cookiePseudo = new Cookie("pseudo",pseudo);
        Cookie cookieMdp = new Cookie("password",password);
        Cookie cookieStatus = new Cookie("status",status);

        response.addCookie(cookiePseudo);
        response.addCookie(cookiePassword);
        response.addCookie(cookieStatus);

        if (status.equals("admin"))
        {
            model.addAttribute("cookieValue", cookieValue);
            return "adminHome";
        } 

        else if (status.equals("teacher"))
        {
            model.addAttribute("cookieValue", cookieValue);
            return "teacherHome";
        }

    }

}
