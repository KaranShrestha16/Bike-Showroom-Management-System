package com.bikeshowroom.karan.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bikeshowroom.karan.daos.suppliersDaos;
import com.bikeshowroom.karan.model.suppliersModel;
@Controller
public class suppliersController {
	@Autowired 
	public suppliersDaos suppliersdoas;
	@RequestMapping(value="addSupplier")
	public String openAddSupplierPage(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		return "addSuppliers";
	}
	@RequestMapping(value="addSupplier",method=RequestMethod.POST)
	public String openAddSupplier(HttpSession session, Model model,@ModelAttribute suppliersModel suppliermodel ){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		
		
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
	
		boolean result=suppliersdoas.getByemail(suppliermodel.getEmail());
		if(result==true){
			suppliersdoas.addSupplier(suppliermodel);
			model.addAttribute("slist", suppliersdoas.getAllSuppliersDetails());
			return "viewSuppliersStaff";
		}else{
			model.addAttribute("error", "email already exit!!!");
			return "addSuppliers";
			
			
		}
		
	}
	@RequestMapping(value="viewSupplierAdmin")
	public String AddSupplierbyAdmin(HttpSession session, Model model,@ModelAttribute suppliersModel suppliermodel ){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", suppliersdoas.getAllSuppliersDetails());
		return "viewSupplierAdmin";
	}
	@RequestMapping(value="/viewSuppliersStaff")
	public String openViewCustomerbyPost(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", suppliersdoas.getAllSuppliersDetails());
		return "viewSuppliersStaff";		
	}
	
	@RequestMapping(value="/{id}/deleteSupplierAdmin",method=RequestMethod.GET)
	public String deleteSupplierDetailsByAdmin(@PathVariable("id")int id,Model model){
		
		suppliersdoas.deleteSupplier(id);
		model.addAttribute("slist", suppliersdoas.getAllSuppliersDetails());
		return "viewSupplierAdmin";
	}
	@RequestMapping(value="/{id}/editSupplier",method=RequestMethod.GET)
	public String updateSupplierDetails(@PathVariable("id") int id,Model model){
		model.addAttribute("supplier", suppliersdoas.getById(id));
	return "editSuppliersStaff";
	}
	@RequestMapping(value="/{id}/editSupplierAdmin",method=RequestMethod.GET)
	public String updateSupplierDetailsByadmin(@PathVariable("id") int id,Model model){
		model.addAttribute("supplier", suppliersdoas.getById(id));
	return "editSupplierAdmin";
	}
	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@ModelAttribute suppliersModel suppliermodel,Model model){
		suppliersdoas.updateUpdate(suppliermodel);
		model.addAttribute("slist", suppliersdoas.getAllSuppliersDetails());
		return "viewSuppliersStaff";
	}
	@RequestMapping(value="/updateSupplierAdmin",method=RequestMethod.POST)
	public String updateSupplierByAdmin(@ModelAttribute suppliersModel suppliermodel,Model model){
		suppliersdoas.updateUpdate(suppliermodel);
		model.addAttribute("slist", suppliersdoas.getAllSuppliersDetails());
		return "viewSupplierAdmin";
	}
	   

	
}
