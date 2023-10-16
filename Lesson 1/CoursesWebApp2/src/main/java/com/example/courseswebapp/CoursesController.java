package com.example.courseswebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CoursesController {
	@RequestMapping("courses")
	public String courses(HttpServletRequest req) {
		String cname = req.getParameter("cname");
		HttpSession session = req.getSession();
		System.out.println("Welcome to "+cname);
		session.setAttribute("cname", cname);
		return "course";
	}
	
	@RequestMapping("course1s")
	public ModelAndView course1s(@RequestParam("cname")String coursename) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cname", coursename);
		mv.setViewName("course");
		return mv;
	}
}
