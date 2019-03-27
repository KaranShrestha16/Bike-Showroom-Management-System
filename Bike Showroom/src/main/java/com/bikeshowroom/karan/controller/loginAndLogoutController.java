package com.bikeshowroom.karan.controller;
import java.awt.List;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bikeshowroom.karan.daos.adminDaos;
import com.bikeshowroom.karan.daos.customerDaos;
import com.bikeshowroom.karan.daos.issueDaos;
import com.bikeshowroom.karan.daos.purchaseDaos;
import com.bikeshowroom.karan.daos.salesDaos;
import com.bikeshowroom.karan.daos.staffDaos;
import com.bikeshowroom.karan.daos.suppliersDaos;
import com.bikeshowroom.karan.model.adminModel;
import com.bikeshowroom.karan.model.staffModel;
@Controller
public class loginAndLogoutController {
	@Autowired
	public adminDaos admindaos;
	@Autowired
	public staffDaos staffdaos;
	@Autowired
	public issueDaos issuedaos;
	@Autowired
	public purchaseDaos purchasedaos;
	@Autowired
	public salesDaos salesdaos;
	@Autowired
	public suppliersDaos supplierdaos;
	@Autowired
	public customerDaos customerdaos;
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute adminModel adminModel,@ModelAttribute staffModel staffmodel, Model model
			,HttpServletRequest request, HttpSession session) throws IOException{	
		 String usertype=request.getParameter("userType");
		if(usertype.equals("admin")){
			adminModel adminDetail=admindaos.login(adminModel.getEmail(),adminModel.getPassword());
			if(adminDetail!=null){	
				session=request.getSession();
				session.setAttribute("id",adminDetail.getAdmin_id());
				session.setAttribute("activeUser",adminDetail.getFullName());
				session.setAttribute("imageName",adminDetail.getImageName());
				model.addAttribute("imageName",adminDetail.getImageName());
				System.out.println(model.addAttribute("imageName",adminDetail.getImageName()));
				model.addAttribute("activeUser",adminDetail.getFullName());
				model.addAttribute("slist", issuedaos.getAllIssue());
				model.addAttribute("supplier",supplierdaos.countSupplier());
				model.addAttribute("purchase",purchasedaos.TotalSum());
				model.addAttribute("sales",salesdaos.totalSales());
				model.addAttribute("staff",staffdaos.countStaff());
				return "adminDashboard";
			}else{	
				model.addAttribute("error", "Email or password doesnot Exist !!");				
				return "login";			
				}	
		}else if(usertype.equals("staff")){				
			staffmodel.setPassword(DigestUtils.md5DigestAsHex(staffmodel.getPassword().getBytes()));
			staffModel staffDetail=staffdaos.staffLogin(staffmodel.getEmail(), staffmodel.getPassword());
			if(staffDetail!=null){
				session=request.getSession();			
				session.setAttribute("id", staffDetail.getId()); 
				session.setAttribute("activeUser", staffDetail.getFirstName()); 
				session.setAttribute("imageName", staffDetail.getImageName()); 
				model.addAttribute("imageName", staffDetail.getImageName()); 
				model.addAttribute("activeUser", staffDetail.getFirstName()); 
				model.addAttribute("supplier",supplierdaos.countSupplier());
				model.addAttribute("purchase",purchasedaos.TotalSum());
				model.addAttribute("sales",salesdaos.totalSales());
				model.addAttribute("customer",customerdaos.countCustomer());			
				return "staffDashboard";
			}else{
				model.addAttribute("error", "Email or password doesnot Exist !!");			
				return "login";			
				}
	}
		return null;
	}
	
	
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String forgetPassword(){	
			
	      return "EmailCheck";    
	     }
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){	
		session.invalidate();	
	      return "login";    
	     }
	
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public String checkEmail(@ModelAttribute adminModel adminModel,@ModelAttribute staffModel staffmodel, Model model
			,HttpServletRequest request) throws IOException{	
		 String usertype=request.getParameter("userType");
		if(usertype.equals("admin")){	
			adminModel adminDetail=admindaos.getAdminDetailsByemail(adminModel.getEmail());
			if(adminDetail!=null){				
			int id=adminDetail.getAdmin_id();
			model.addAttribute("admin", admindaos.getAdminDetailsById(id));
			return "updatePasswordforAdmin";
			}else{
				
				model.addAttribute("error", "Email do not Exist !!");			
				return "EmailCheck";	
			}
		}else if(usertype.equals("staff")){				
			staffModel staffDetail=staffdaos.getByemail(staffmodel.getEmail());
			if(staffDetail!=null){
			int id=staffDetail.getId();
			model.addAttribute("staff", staffdaos.getById(id));
			return "updatePasswordforStaff";
			}else{
				model.addAttribute("error", "Email do not Exist !!");			
				return "EmailCheck";
			}
		}
		return "EmailCheck";
	      
	     }
	
	@RequestMapping(value = "/updatePasswordforAdmin", method = RequestMethod.POST)
	public String updatePassword(HttpSession session,Model model,adminModel adminmodel){	
		admindaos.updateAdmin(adminmodel);
		return "login";
		
	   
	    
	}
	
	@RequestMapping(value = "/updatePasswordforStaff", method = RequestMethod.POST)
	public String updatePasswordforStaff(HttpSession session,Model model,staffModel staffmodel){	
		//hashing
	    staffmodel.setPassword(DigestUtils.md5DigestAsHex(staffmodel.getPassword().getBytes()));
		staffdaos.updateStaff(staffmodel);
		return "login";
		
	   
	    
	}
}
