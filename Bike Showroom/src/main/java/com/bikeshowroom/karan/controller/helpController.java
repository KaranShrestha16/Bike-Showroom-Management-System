package com.bikeshowroom.karan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bikeshowroom.karan.daos.issueDaos;
import com.bikeshowroom.karan.model.IssueModel;
@Controller
public class helpController {
 @Autowired
public issueDaos issuedaos;
	@RequestMapping(value="/help")
	public String openhelpPagee(HttpSession session,Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
	
		
		
		return"help";
	}
	
	@RequestMapping(value="/addHelp",method=RequestMethod.POST)
	public String addhelp(HttpSession session,Model model,@ModelAttribute IssueModel issuemodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		System.out.println(activeUser);
		issuemodel.setStaffName(activeUser);
		issuedaos.addIssue(issuemodel);
		return "help";
	}
	
	
	
	
}
