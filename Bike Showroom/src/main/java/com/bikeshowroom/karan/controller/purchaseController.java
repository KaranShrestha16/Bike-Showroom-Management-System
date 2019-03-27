package com.bikeshowroom.karan.controller;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bikeshowroom.karan.daos.productDaos;
import com.bikeshowroom.karan.daos.purchaseDaos;
import com.bikeshowroom.karan.daos.suppliersDaos;
import com.bikeshowroom.karan.model.customerModel;
import com.bikeshowroom.karan.model.productModel;
import com.bikeshowroom.karan.model.purchaseModel;
@Controller
public class purchaseController {
	@Autowired
	public purchaseDaos purchasedaos;
	@Autowired
	public suppliersDaos supplierdaos;
	@Autowired
	public productDaos productdaos;
	@RequestMapping(value="/addPurchase")
	public String openAddPurchasePage(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("supplierList", supplierdaos.getAllSuppliersDetails());
		return "addPurchase";
	}
	
	@RequestMapping(value="/addPurchase",method=RequestMethod.POST)
	public String AddPurchase(HttpSession session, Model model,@ModelAttribute purchaseModel purchasemodel,@ModelAttribute productModel productmodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("supplierList", supplierdaos.getAllSuppliersDetails());
		
		productmodel =productdaos.getDetailsByProductName(purchasemodel.getProductName());
		int quantity=purchasemodel.getQuantity();
		int quantity2=productmodel.getQuantity();
		int quantity3=quantity+quantity2;
		productmodel.setQuantity(quantity3);
		productdaos.updateProduct(productmodel);
		purchasedaos.addPurchase(purchasemodel);
		model.addAttribute("slist", purchasedaos.getAllPurchaseDetails());
		return "viewPurchaseStaff";
	}
	@RequestMapping(value="/viewPurchaseStaff")
	public String openViewPurchasepage(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", purchasedaos.getAllPurchaseDetails());
		return "viewPurchaseStaff";	
	}
	
	@RequestMapping(value="/viewPurchaseAdmin")
	public String openviewPurchaseAdminPage(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", purchasedaos.getAllPurchaseDetails());
		return "viewPurchaseAdmin";	
	}
	@RequestMapping(value="/viewPurchaseStaff",method=RequestMethod.POST)
	public String ViewPurchaseByPost(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", purchasedaos.getAllPurchaseDetails());
		return "viewPurchaseStaff";
		
	}
	
	@RequestMapping(value="/{id}/editPurchaseByStaff",method=RequestMethod.GET)
	public String editPurchaseByStaff(@PathVariable("id") int id,Model model){
		model.addAttribute("purchase", purchasedaos.getById(id));
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("supplierList", supplierdaos.getAllSuppliersDetails());
	return "editPurchaseStaff";
	}
	@RequestMapping(value="/{id}/editPurchaseByAdmin",method=RequestMethod.GET)
	public String editPurchaseByAdmin(@PathVariable("id") int id,Model model){
		model.addAttribute("purchase", purchasedaos.getById(id));
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("supplierList", supplierdaos.getAllSuppliersDetails());
	return "editPurchaseAdmin";
	}
	

	@RequestMapping(value="/updatePurchaseByStaff",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updatePurchaseByStaff(@ModelAttribute purchaseModel purchasemodel,@ModelAttribute productModel productmodel,HttpServletRequest request,Model model){	
		
		
		productmodel =productdaos.getDetailsByProductName(purchasemodel.getProductName());
		productmodel.setQuantity(purchasemodel.getQuantity());
		productdaos.updateProduct(productmodel);
		purchasedaos.updatePurchase(purchasemodel);
		model.addAttribute("slist", purchasedaos.getAllPurchaseDetails());
		return "viewPurchaseStaff";
	}
	@RequestMapping(value="/updatePurchaseByAdmin",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updatePurchaseByAdmin(@ModelAttribute purchaseModel purchasemodel,@ModelAttribute productModel productmodel,HttpServletRequest request,Model model){	
		productmodel =productdaos.getDetailsByProductName(purchasemodel.getProductName());
		productmodel.setQuantity(purchasemodel.getQuantity());
		productdaos.updateProduct(productmodel);
		purchasedaos.updatePurchase(purchasemodel);
		model.addAttribute("slist", purchasedaos.getAllPurchaseDetails());
		return "viewPurchaseAdmin";
	}
	@RequestMapping(value="/{id}/deletePurchaseByAdmin",method=RequestMethod.GET)
	public String deleteProductDetails(@PathVariable("id")int id,Model model){	
		purchasedaos.deletePurchase(id);
		model.addAttribute("slist", purchasedaos.getAllPurchaseDetails());
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("supplierList", supplierdaos.getAllSuppliersDetails());
		return "viewPurchaseAdmin";
	}
	
	
}
