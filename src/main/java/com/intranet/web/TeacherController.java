package com.intranet.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.intranet.metier.*;
import com.intranet.entities.*;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	private IntranetMetierInterface intranetMetierInterface;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String adminHome(Model model)
	{
		List<News> news = intranetMetierInterface.getActiveNewsList();
		List<String> newsList = new ArrayList();
		List<String> dateList = new ArrayList();
		List<String> collapseIdList = new ArrayList();
		List<String> headingIdList = new ArrayList();
		
		
		int[] idx = { 0 };
		news.forEach(newsElem -> {
			newsList.add(newsElem.getContent());
			
			DateFormat df = new SimpleDateFormat("dd/MM - HH:mm");
			dateList.add(df.format(newsElem.getDate()));
			
			collapseIdList.add("collapse"+String.valueOf(idx[0]));
			headingIdList.add("heading"+String.valueOf(idx[0]++));
		});
		
		model.addAttribute("newsList", newsList);
		model.addAttribute("dateList", dateList);
		model.addAttribute("collapseIdList", collapseIdList);
		model.addAttribute("headingIdList", headingIdList);
		
		return "teacherHome";
	}
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String adminNews(Model model)
	{
		List<News> news = intranetMetierInterface.getActiveNewsList();
		List<String> newsList = new ArrayList();
		List<String> collapseIdList = new ArrayList();
		List <String> headingIdList = new ArrayList();
		
		int[] idx = { 0 };
		news.forEach(newsElem -> {
			newsList.add(newsElem.getContent());
			collapseIdList.add("collapse"+String.valueOf(idx[0]));
			headingIdList.add("heading"+String.valueOf(idx[0]++));
		});
		
		model.addAttribute("newsList", newsList);
		model.addAttribute("collapseIdList", collapseIdList);
		model.addAttribute("headingIdList", headingIdList);
		
		return "newsList";
	}
	
	@RequestMapping(value = "/addGrade", method = { RequestMethod.GET, RequestMethod.POST })
	public String adminAddStudent(HttpServletRequest request, Model model,
			@RequestParam(required=false, name="studentNameSelect") String studentNameSelect)
	{
		if(request.getParameter("gradeStep").equals("1")) {
			List<String> studentNameList = new ArrayList<>();
			for(Student student : intranetMetierInterface.getStudentListWithSectionName()) 
				studentNameList.add(student.getName());
			model.addAttribute("studentList", studentNameList);
			model.addAttribute("gradeStep", 1);
			return "teacherAddGrade";
		} else if (request.getParameter("gradeStep").equals("2")) {
			model.addAttribute("gradeStep", 2);
			List<String> courseNameList = new ArrayList<>();
			for(Course course : intranetMetierInterface.getCourseFromStudentName(studentNameSelect)) 
				courseNameList.add(course.getName());
			model.addAttribute("courseNameList", courseNameList);
			model.addAttribute("studentNameSelect", studentNameSelect);
			return "teacherAddGrade";
		}
		return "redirect:/error";
	}
	@RequestMapping(value = "/op/addGrade", method = RequestMethod.POST)
	public String addNews(HttpServletRequest request, Model model,
			@RequestParam(name="gradeInput") Integer grade,
			@RequestParam(name="courseNameSelect") String courseNameSelect)
	{
		if(grade != null) {
			String studentName = request.getParameter("studentNameSelect");
			intranetMetierInterface.createEvaluation(intranetMetierInterface.getStudentFromName(studentName), intranetMetierInterface.getCourseFromName(courseNameSelect), grade);
			System.out.println("AA");
			return "redirect:/teacher/home";
		}
		return "redirect:/error";
	}
}
