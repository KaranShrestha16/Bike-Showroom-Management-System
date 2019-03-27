package com.bikeshowroom.karan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class reportController {

	@RequestMapping(value="/salesReport")
	public String openSalesReportPage(HttpSession session,Model model ){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		String e= (String) session.getAttribute("activeUser");
		model.addAttribute("activeUser", e);
		
		return "salesReport";
	}
	@RequestMapping(value="/purchaseReoprt")
	public String openPurchaseReportPage(HttpSession session,Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		String e= (String) session.getAttribute("activeUser");
		model.addAttribute("activeUser", e);
		
		return"purchaseReoprt";
	}
	@RequestMapping(value="/generateBill")
	public String openBillPage(HttpSession session,Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		String e= (String) session.getAttribute("activeUser");
		model.addAttribute("activeUser", e);
		
		return"bill";
	}
	
	
}
	
	
