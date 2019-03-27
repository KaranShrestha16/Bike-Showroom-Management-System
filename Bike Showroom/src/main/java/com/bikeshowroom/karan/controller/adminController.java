package com.bikeshowroom.karan.controller;
import java.awt.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.type.descriptor.java.CurrencyTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bikeshowroom.karan.daos.adminDaos;
import com.bikeshowroom.karan.daos.customerDaos;
import com.bikeshowroom.karan.daos.issueDaos;
import com.bikeshowroom.karan.daos.purchaseDaos;
import com.bikeshowroom.karan.daos.salesDaos;
import com.bikeshowroom.karan.daos.staffDaos;
import com.bikeshowroom.karan.daos.suppliersDaos;
import com.bikeshowroom.karan.model.adminModel;
@Controller
public class adminController {	
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
	@RequestMapping(value="/adminProfile")
	public String openAdminProfile(HttpSession session,Model model,adminModel adminmodel){
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
		
		int id=(Integer) session.getAttribute("id");

		model.addAttribute("adminDetails",admindaos.getAdminDetailsById(id));
		return "adminProfile";
	}	
	
	
	@RequestMapping(value="/dashboard")
	public String openDashboardPage(HttpSession session,Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("slist", issuedaos.getAllIssue());
		model.addAttribute("supplier",supplierdaos.countSupplier());
		model.addAttribute("purchase",purchasedaos.TotalSum());
		model.addAttribute("sales",salesdaos.totalSales());
		model.addAttribute("staff",staffdaos.countStaff());
		return "adminDashboard";
	}
	
	@RequestMapping(value="/addAdmin")
	public String openAddAdminPage(HttpSession session,Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
	
		return "addAdmin";
	}
	
	@RequestMapping(value="/addAdmin", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute adminModel adminmodel, HttpServletRequest req, 
Model model,@RequestParam("file[]") CommonsMultipartFile[] file, HttpSession session) throws IOException
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}


		String path=session.getServletContext().getRealPath("/");
		
		for (CommonsMultipartFile f:file) //for loop not
		{
			String extension = FilenameUtils.getExtension(f.getOriginalFilename());

			if (extension.equals("jpg")||extension.equals("jpeg")||extension.equals("png"))
			{
				String filename=f.getOriginalFilename();
				System.out.println(path+" "+filename);		
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				System.out.println(dir.getAbsolutePath());
				
				if (!dir.exists())
					dir.mkdirs();	
				try
				{
					byte barr[]=f.getBytes();					  
					BufferedOutputStream bout=new BufferedOutputStream(new 
				FileOutputStream(path+"/resources/images/"+filename));
					Object o=bout;
					bout.write(barr);
					bout.flush();
					bout.close();
				 System.out.println(filename);
				 adminmodel.setImageName(filename);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else
			{
				model.addAttribute("ex", "File Format not supported!!!!!");
				return "addAdmin";
			}
		}
		
		boolean result=admindaos.emailCheck(adminmodel.getEmail());
		if(result==true){
		//hashing
		
		adminmodel.setUserType("admin");
		admindaos.addAdmin(adminmodel);
		
		model.addAttribute("slist", admindaos.getAlladminDetails());
		return "viewAdmin";
		}else{
			
			model.addAttribute("error", "email already exit!!!");
			return "addAdmin";
		}
		}
	
	
	@RequestMapping(value="/viewAdmin")
	public String openViewAdmin(Model model,HttpSession session){
		model.addAttribute("slist", admindaos.getAlladminDetails());	
		return "viewAdmin";
	}
	
	@RequestMapping(value="/{id}/deleteAdmin",method=RequestMethod.GET)
	public String deleteAdminDetails(@PathVariable("id")int id,Model model){
		
		admindaos.deleteAdmin(id);
		model.addAttribute("slist", admindaos.getAlladminDetails());
		return "viewAdmin";
	}
	@RequestMapping(value="/{id}/editAdmin",method=RequestMethod.GET)
	public String updateAdminDetails(@PathVariable("id") int id,Model model){
		model.addAttribute("admin", admindaos.getAdminDetailsById(id));
	return "editAdmin";
	}
	@RequestMapping(value="/updateAdmin",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updateAdmin(@ModelAttribute adminModel adminmodel,Model model){
		admindaos.updateAdmin(adminmodel);;
		model.addAttribute("slist", admindaos.getAlladminDetails());
		return "viewAdmin";
	}
	
	@RequestMapping(value="/updateAdminByAdmin",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updateAdminByAdmin(@ModelAttribute adminModel adminmodel, HttpServletRequest req, 
Model model,@RequestParam("file[]") CommonsMultipartFile[] file, HttpSession session) throws IOException
	{
String path=session.getServletContext().getRealPath("/");
		
		for (CommonsMultipartFile f:file) //for loop not
		{
			String extension = FilenameUtils.getExtension(f.getOriginalFilename());

			if (extension.equals("jpg")||extension.equals("jpeg")||extension.equals("png"))
			{
				String filename=f.getOriginalFilename();
				System.out.println(path+" "+filename);		
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				System.out.println(dir.getAbsolutePath());
				
				if (!dir.exists())
					dir.mkdirs();	
				try
				{
					byte barr[]=f.getBytes();					  
					BufferedOutputStream bout=new BufferedOutputStream(new 
				FileOutputStream(path+"/resources/images/"+filename));
					Object o=bout;
					bout.write(barr);
					bout.flush();
					bout.close();
				 System.out.println(filename);
				 adminmodel.setImageName(filename);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else
			{
				model.addAttribute("ex", "File Format not supported!!!!!");
				return "addAdmin";
			}
		}
		
		admindaos.updateAdmin(adminmodel);
		int id=(Integer) session.getAttribute("id");

		model.addAttribute("adminDetails",admindaos.getAdminDetailsById(id));
		adminmodel=admindaos.getAdminDetailsById(id);
		session.setAttribute("id",adminmodel.getAdmin_id());
		session.setAttribute("activeUser",adminmodel.getFullName());
		session.setAttribute("imageName",adminmodel.getImageName());
		
		
		return "adminProfile";
	}
	@RequestMapping(value="/{id}/editAdminProfile",method=RequestMethod.GET)
	public String editAdminProfile(@PathVariable("id") int id,Model model){
		model.addAttribute("admin", admindaos.getAdminDetailsById(id));
	return "editAdminProfile";
	}
	
	
	
}
