package com.intranet.web;

import java.util.List;
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

import com.intranet.metier.*;
import com.intranet.entities.*;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private IntranetMetierInterface intranetMetierInterface;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String adminHome(Model model)
	{
		List<News> news = intranetMetierInterface.getActiveNewsList();
		List<String> newsList = new ArrayList();
		List<String> dateList = new ArrayList();
		List<String> collapseIdList = new ArrayList();
		List <String> headingIdList = new ArrayList();
		
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
		
		model.addAttribute("sectionList", intranetMetierInterface.getSectionList()); 
		return "adminHome";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String adminAddStudent(Model model)
	{
		List<String> sectionListString = new ArrayList<>();
		for(Section section : intranetMetierInterface.getSectionList()) 
			sectionListString.add(section.getName());
		model.addAttribute("sectionList", sectionListString);
		return "adminAddStudent";
	}
	@RequestMapping(value = "/op/addStudent", method = RequestMethod.POST)
	public String addStudent(Model model,
			@RequestParam("studentFN") String studentFN,
			@RequestParam("studentLN") String studentLN,
			@RequestParam("studentLogin") String studentLogin,
			@RequestParam("studentPwd") String studentPwd,
			@RequestParam("studentSectionSelect") String studentSectionSelect)
	{
		for(Section section : intranetMetierInterface.getSectionList()) {
			if (studentSectionSelect.toUpperCase().equals(section.getName())) {
				intranetMetierInterface.createStudent(studentFN, studentLogin, studentPwd, intranetMetierInterface.getSectionFromName(studentSectionSelect.toUpperCase()));
				return "redirect:/admin/home";
			}
		}
		return "redirect:/error";
	}
	
	@RequestMapping(value = "/addNews", method = RequestMethod.GET)
	public String adminAddNews(Model model) {
		return "adminAddNews";
	}
	@RequestMapping(value = "/op/addNews", method = RequestMethod.POST)
	public String addNews(Model model, @RequestParam("newsContent") String newsContent)
	{
		if (!newsContent.isEmpty()) {
			intranetMetierInterface.createNews(newsContent, new Date());
			return "redirect:/admin/home";
		}
		return "redirect:/error";
	}
}
