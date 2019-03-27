package com.bikeshowroom.karan.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
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
import com.bikeshowroom.karan.model.staffModel;
@Controller
public class staffController {
	@Autowired
	public customerDaos customerdaos;
	@Autowired
	public staffDaos staffDaos;
	@Autowired
	public issueDaos issuedaos;
	@Autowired
	public purchaseDaos purchasedaos;
	@Autowired
	public salesDaos salesdaos;
	@Autowired
	public suppliersDaos supplierdaos;
	
	@RequestMapping(value="/addStaff")
	public String openAddStaff(HttpSession session, Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))||
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		
		
		return "addStaff";
	}
	@RequestMapping(value="/staffProfile")
	public String openAdminProfile(HttpSession session,Model model,staffModel staffmodel){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		
		int id=(Integer) session.getAttribute("id");
		System.out.println(id);
		model.addAttribute("staffDetails",staffDaos.getById(id));
		return "staffProfile";
	}
	@RequestMapping(value="/staffDashboard")
	public String openDashboardPage(HttpSession session,Model model){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);
		model.addAttribute("supplier",supplierdaos.countSupplier());
		model.addAttribute("purchase",purchasedaos.TotalSum());
		model.addAttribute("sales",salesdaos.totalSales());
		model.addAttribute("customer",customerdaos.countCustomer());
		return "staffDashboard";
	}
	@RequestMapping(value="/viewStaff")
	public String openViewStaff(Model model,HttpSession session){
		model.addAttribute("slist", staffDaos.getAllStaffDetails());	
		return "viewStaff";
	}
	@RequestMapping(value="/viewStaff",method=RequestMethod.POST)
	public String openViewStaffbyPost(@ModelAttribute staffModel staffmodel,Model model, HttpSession session){
		if(StringUtils.isEmpty(session.getAttribute("id"))|| StringUtils.isEmpty(session.getAttribute("activeUser"))|| 
				StringUtils.isEmpty(session.getAttribute("imageName"))){
			return "login";
		}
		String activeUser= (String) session.getAttribute("activeUser");
		String imageName= (String) session.getAttribute("imageName");
		model.addAttribute("activeUser", activeUser);
		model.addAttribute("imageName", imageName);	
		staffDaos.staffRegister(staffmodel);	
		model.addAttribute("slist", staffDaos.getAllStaffDetails());	
		return "viewStaff";	
	}
	
	@RequestMapping(value="/staffRegister", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute staffModel staffmodel, HttpServletRequest req, 
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
				 staffmodel.setImageName(filename);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else
			{
				model.addAttribute("ex", "File Format not supported!!!!!");
				return "addStaff";
			}
		}
	
		boolean result=staffDaos.CheckEmail(staffmodel.getEmail());
		if(result==true){
		//hashing
		staffmodel.setPassword(DigestUtils.md5DigestAsHex(staffmodel.getPassword().getBytes()));
		
		staffDaos.staffRegister(staffmodel);
		model.addAttribute("slist", staffDaos.getAllStaffDetails());
		return "viewStaff";
		}else{
			
			model.addAttribute("error", "email already exit!!!");
			return "addStaff";
		}
		
		
		}
	@RequestMapping(value="/{id}/deletestaff",method=RequestMethod.GET)
	public String deleteStaffDetails(@PathVariable("id")int id,Model model){
		
		staffDaos.deleteStaff(id);
		model.addAttribute("slist", staffDaos.getAllStaffDetails());
		return "viewStaff";
	}
	@RequestMapping(value="/{id}/editstaff",method=RequestMethod.GET)
	public String updateStaffDetails(@PathVariable("id") int id,Model model){
		model.addAttribute("staff", staffDaos.getById(id));
	return "editStaff";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updateStaff(@ModelAttribute staffModel staffmodel,Model model){
		staffDaos.updateStaff(staffmodel);
		model.addAttribute("slist", staffDaos.getAllStaffDetails());
		return "viewStaff";
	}
	
	@RequestMapping(value="/{id}/editStaffProfile",method=RequestMethod.GET)
	public String editStaffProfile(@PathVariable("id") int id,Model model){
		model.addAttribute("staff", staffDaos.getById(id));
	return "editStaffProfile";
	}
	

	@RequestMapping(value="/updateStaffProfileByStaff",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updateStaffProfileByStaff(@ModelAttribute staffModel staffmodel, HttpServletRequest req, 
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
				 staffmodel.setImageName(filename);
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
		
		staffDaos.updateStaff(staffmodel);
		int id=(Integer) session.getAttribute("id");

		model.addAttribute("staffDetails",staffDaos.getById(id));
		staffmodel=staffDaos.getById(id);
		session.setAttribute("id",staffmodel.getId());
		session.setAttribute("activeUser",staffmodel.getFirstName());
		session.setAttribute("imageName",staffmodel.getImageName());
		
		return "staffProfile";
	}
	
}
