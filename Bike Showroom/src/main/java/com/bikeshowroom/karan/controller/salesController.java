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
import com.bikeshowroom.karan.daos.customerDaos;
import com.bikeshowroom.karan.daos.productDaos;
import com.bikeshowroom.karan.daos.salesDaos;
import com.bikeshowroom.karan.model.customerModel;
import com.bikeshowroom.karan.model.productModel;
import com.bikeshowroom.karan.model.salesModel;
@Controller
public class salesController {	
	@Autowired
	public customerDaos customerdaos;
	@Autowired
	public productDaos productdaos;
	@Autowired
	public salesDaos salesdaos;	
	@RequestMapping(value="addSales")
	public String openAddSalesPage(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("productList", productdaos.getAllProductDetails());
	model.addAttribute("customerList", customerdaos.getAllCustomerDetails());
		return "addSales";		
	}	
	@RequestMapping(value="/addSales",method=RequestMethod.POST)
	public String AddSales(HttpSession session, Model model,@ModelAttribute salesModel salesmodel,@ModelAttribute productModel productmodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("customerList", customerdaos.getAllCustomerDetails());
		productmodel =productdaos.getDetailsByProductName(salesmodel.getProductName());
		
		int quantity1=productmodel.getQuantity();
		int quantity2=salesmodel.getQuantity();
		int quantity=quantity1-quantity2;
		 if(quantity>0){
			productmodel.setQuantity(quantity);
		    productdaos.updateProduct(productmodel);
		    salesdaos.addSales(salesmodel);
		    model.addAttribute("slist", salesdaos.getAllSalesDetails());
			return "viewSalesStaff";
		 }else{
			 
			model.addAttribute("error","Out of Stock!!!!! " );
			return "addSales";
		 }
		 
		 } 
	@RequestMapping(value="viewSalesStaff")
	 public String openViewSalesStaff(HttpSession session, Model model,@ModelAttribute salesModel salesmodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", salesdaos.getAllSalesDetails());
		return "viewSalesStaff";	
	}
	
	@RequestMapping(value="viewSalesAdmin")
	 public String viewSalesAdmin(HttpSession session, Model model,@ModelAttribute salesModel salesmodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", salesdaos.getAllSalesDetails());
		return "viewSalesAdmin";	
	}
	
	@RequestMapping(value="/viewSalesStaff",method=RequestMethod.POST)
	public String openViewCustomerbyPost(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))||StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", salesdaos.getAllSalesDetails());						
		return "viewSalesStaff";		
	}
	
	@RequestMapping(value="/viewSalesAdmin",method=RequestMethod.POST)
	public String viewSalesAdmin(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))||StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", salesdaos.getAllSalesDetails());						
		return "viewSalesAdmin";		
	}
	
	@RequestMapping(value="/{id}/editSalesByStaff",method=RequestMethod.GET)
	public String editSalesByStaff(@PathVariable("id") int id,Model model){
		model.addAttribute("sales", salesdaos.getById(id));
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("customerList", customerdaos.getAllCustomerDetails());
	return "editSalesStaff";
	}
	@RequestMapping(value="/{id}/editSalesByAdmin",method=RequestMethod.GET)
	public String editSalesByAdmin(@PathVariable("id") int id,Model model){
		model.addAttribute("sales", salesdaos.getById(id));
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("customerList", customerdaos.getAllCustomerDetails());
	return "editSalesAdmin";
	}
	
	
	@RequestMapping(value="/updateSalesByStaff",method=RequestMethod.POST)
	public String updateSalesByStaff(@ModelAttribute productModel productmodel,Model model,@ModelAttribute salesModel salesmodel){				
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("customerList", customerdaos.getAllCustomerDetails());
		productmodel =productdaos.getDetailsByProductName(salesmodel.getProductName());
		
		int quantity1=productmodel.getQuantity();
		int quantity2=salesmodel.getQuantity();
		int quantity=quantity1-quantity2;
		 if(quantity>0){
			productmodel.setQuantity(quantity);
		    productdaos.updateProduct(productmodel);
		    salesdaos.updateSales(salesmodel);
		    model.addAttribute("slist", salesdaos.getAllSalesDetails());
			return "viewSalesStaff";
		 }else{
			 
			model.addAttribute("error","Out of Stock!!!!! " );
			return "editSalesSataff";
		 }
		 
	}	
	
	@RequestMapping(value="/updateSalesByAdmin",method=RequestMethod.POST)
	public String updateSalesByAdmin(@ModelAttribute productModel productmodel,Model model,@ModelAttribute salesModel salesmodel){				
		model.addAttribute("productList", productdaos.getAllProductDetails());
		model.addAttribute("customerList", customerdaos.getAllCustomerDetails());
		productmodel =productdaos.getDetailsByProductName(salesmodel.getProductName());
		
		int quantity1=productmodel.getQuantity();
		int quantity2=salesmodel.getQuantity();
		int quantity=quantity1-quantity2;
		 if(quantity>0){
			productmodel.setQuantity(quantity);
		    productdaos.updateProduct(productmodel);
		    salesdaos.updateSales(salesmodel);
		    model.addAttribute("slist", salesdaos.getAllSalesDetails());
			return "viewSalesAdmin";
		 }else{
			 
			model.addAttribute("error","Out of Stock!!!!! " );
			return "editSalesAdmin";
		 }
		 
	}	
	
	@RequestMapping(value="/{id}/deleteSalesByAdmin",method=RequestMethod.GET)
	public String deleteSalesByAdmin(@PathVariable("id")int id,Model model){		
		salesdaos.deleteSales(id);;		
		model.addAttribute("slist", salesdaos.getAllSalesDetails());
		return "viewSalesAdmin";		
	}	
	
}



