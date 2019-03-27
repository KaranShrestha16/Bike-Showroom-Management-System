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

import com.bikeshowroom.karan.daos.productDaos;
import com.bikeshowroom.karan.model.customerModel;
import com.bikeshowroom.karan.model.productModel;
@Controller
public class productController {
	@Autowired
	public productDaos productdaos;
	@RequestMapping(value="addProduct")
	public String openAddProductPage(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		return "addProduct";		
	}	
	@RequestMapping(value="addProduct",method=RequestMethod.POST)
	public String AddProduct(HttpSession session, Model model,@ModelAttribute productModel productmodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
	
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);	
		
		
		boolean result=productdaos.getByProductName(productmodel.getProductName());
		if(result==true){
		productmodel.setAvaibility("yes");
		productdaos.addProduct(productmodel);
		model.addAttribute("slist", productdaos.getAllProductDetails());
		return "viewProductStaff";	
		}else{
			model.addAttribute("error", "This Product is  already exit!!!");
			return "addProduct";
			}
		
	}
	@RequestMapping(value="/viewProductStaff")
	public String openViewProduct(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", productdaos.getAllProductDetails());
		return "viewProductStaff";	
	}
	
	@RequestMapping(value="/viewProductAdmin")
	public String openviewProductAdminPage(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", productdaos.getAllProductDetails());
		return "viewProductAdmin";	
	}
	
	
	@RequestMapping(value="/viewProductStaff",method=RequestMethod.POST)
	public String openViewProductByPost(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", productdaos.getAllProductDetails());
		return "viewProductStaff";
	}
	@RequestMapping(value="/{id}/editProduct",method=RequestMethod.GET)
	public String updateProductDetails(@PathVariable("id") int id,Model model){
		model.addAttribute("product", productdaos.getById(id));
	return "editProductStaff";
	}
	
	@RequestMapping(value="/{id}/editProductByAdmin",method=RequestMethod.GET)
	public String editProductByAdmin(@PathVariable("id") int id,Model model){
		model.addAttribute("product", productdaos.getById(id));
		
	return "editProductAdmin";
	}
	
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updateCustomer(@ModelAttribute productModel productmodel,Model model){	
		productdaos.updateProduct(productmodel);
		model.addAttribute("slist", productdaos.getAllProductDetails());
		return "viewProductStaff";
	}

	
	
	@RequestMapping(value="/updateProductbyAdmin",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updateProductbyAdmin(@ModelAttribute productModel productmodel,Model model){	
		productdaos.updateProduct(productmodel);
		model.addAttribute("slist", productdaos.getAllProductDetails());
		return "viewProductAdmin";
	}
	
	
	@RequestMapping(value="/{id}/deleteProduct",method=RequestMethod.GET)
	public String deleteProductDetails(@PathVariable("id")int id,Model model){	
		productdaos.deleteProduct(id);
		model.addAttribute("slist", productdaos.getAllProductDetails());
		return "viewProductAdmin";
	}
	
}
