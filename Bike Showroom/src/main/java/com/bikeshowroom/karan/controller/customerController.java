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
import com.bikeshowroom.karan.model.customerModel;
import com.bikeshowroom.karan.model.staffModel;
@Controller
public class customerController {	
		@Autowired
		public customerDaos customerdaos;	
		@RequestMapping(value="/addCustomer")
		public String openCustomerPage(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		return "addCustomer";	
	}
		@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
		public String addCustomer(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
			if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
					StringUtils.isEmpty(session.getAttribute("imageName"))){
				return "login";
			}
			int staffId=(Integer)session.getAttribute("id");		
			String activeUser= (String) session.getAttribute("activeUser");
			String imageName= (String) session.getAttribute("imageName");
			model.addAttribute("activeUser", activeUser);
			model.addAttribute("imageName", imageName);
			boolean result=customerdaos.emailCheck(customermodel.getEmail());
			if(result==true){
			customerdaos.addCustomer(customermodel);
			model.addAttribute("slist", customerdaos.getAllCustomerDetails());
			return "viewCustomerStaff";
			}else{
				model.addAttribute("error", "email already exit!!!");
				return "addCustomer";
				
			}
		}
		@RequestMapping(value="/viewCustomerStaff",method=RequestMethod.POST)
		public String openViewCustomerbyPost(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
			if(StringUtils.isEmpty(session.getAttribute("id"))||StringUtils.isEmpty(session.getAttribute("activeUser"))||
					StringUtils.isEmpty(session.getAttribute("imageName"))){
				return "login";
			}
			String activeUser= (String) session.getAttribute("activeUser");
			String imageName= (String) session.getAttribute("imageName");
			model.addAttribute("activeUser", activeUser);
			model.addAttribute("imageName", imageName);
			model.addAttribute("slist", customerdaos.getAllCustomerDetails());						
			return "viewCustomerStaff";		
		}
		
		@RequestMapping(value="/viewCustomerStaff")
		public String openViewCustomer(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
			if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
StringUtils.isEmpty(session.getAttribute("imageName"))){
				return "login";
			}
			String activeUser= (String) session.getAttribute("activeUser");
			String imageName= (String) session.getAttribute("imageName");
			model.addAttribute("activeUser", activeUser);
			model.addAttribute("imageName", imageName);		
			model.addAttribute("slist", customerdaos.getAllCustomerDetails());		
			return "viewCustomerStaff";	
		}	
		@RequestMapping(value="/viewCustomerAdmin",method=RequestMethod.POST)
		public String ViewCustomerbyPostAdmin(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
			if(StringUtils.isEmpty(session.getAttribute("id"))||StringUtils.isEmpty(session.getAttribute("activeUser"))||
					StringUtils.isEmpty(session.getAttribute("imageName"))){
				return "login";
			}
			String activeUser= (String) session.getAttribute("activeUser");
			String imageName= (String) session.getAttribute("imageName");
			model.addAttribute("activeUser", activeUser);
			model.addAttribute("imageName", imageName);
			model.addAttribute("slist", customerdaos.getAllCustomerDetails());			
			return "viewCustomerAdmin";		
		}	
		@RequestMapping(value="/viewCustomerAdmin")
		public String openViewCustomerAdmin(HttpSession session, Model model,@ModelAttribute customerModel customermodel){
			if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
					StringUtils.isEmpty(session.getAttribute("imageName"))){
				return "login";
			}
			String activeUser= (String) session.getAttribute("activeUser");
			String imageName= (String) session.getAttribute("imageName");
			model.addAttribute("activeUser", activeUser);
			model.addAttribute("imageName", imageName);		
			model.addAttribute("slist", customerdaos.getAllCustomerDetails());			
			return "viewCustomerAdmin";		
		}
		
		@RequestMapping(value="/{id}/deleteCustomerByAdmin",method=RequestMethod.GET)
		public String deleteCustomrDetailsByAdmin(@PathVariable("id")int id,Model model){		
			customerdaos.deleteCustomer(id);		
			model.addAttribute("slist", customerdaos.getAllCustomerDetails());
			return "viewCustomerAdmin";		
		}	
		@RequestMapping(value="/{id}/editCustomerStaff",method=RequestMethod.GET)
		public String updateCustomerDetailsbyStaff(@PathVariable("id") int id,Model model){
			model.addAttribute("customer", customerdaos.getById(id));
		return "editCustomerStaff";
		}	
		@RequestMapping(value="/{id}/editCustomerByAdmin",method=RequestMethod.GET)
		public String updateCustomerDetailsbyAdmin(@PathVariable("id") int id,Model model){
			model.addAttribute("customer", customerdaos.getById(id));
		return "editCustomerAdmin";
		}	
		@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
		public String updateCustomer(@ModelAttribute customerModel customermodel,Model model){				
			customerdaos.updateUpdate(customermodel);
			model.addAttribute("slist", customerdaos.getAllCustomerDetails());
			return "viewCustomerStaff";
		}	
		@RequestMapping(value="/updateCustomerAdmin",method=RequestMethod.POST)
		public String updateCustomerAdmin(@ModelAttribute customerModel customermodel,Model model){	
			customerdaos.updateUpdate(customermodel);
			model.addAttribute("slist", customerdaos.getAllCustomerDetails());
			return "viewCustomerAdmin";
		}
			
}
