package demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.springboot.entity.User;
import demo.springboot.repository.UserRepository;
import demo.springboot.service.DesignationService;
import demo.springboot.service.UserService;
import demo.springboot.validation.Validate;

@Controller
public class UserController {
	@Autowired
	UserRepository urepo;
	@Autowired
	UserService service;
	@Autowired
	DesignationService dservice;
	@Autowired
	Validate valid;
	
	
//	Home Page
	@GetMapping("/")
	public String getAll(Model model)
	{
		model.addAttribute("users", service.getAll());
		return "home";
	}
	
//	Add Page
	@GetMapping("/addUser")
    public String addPage(Model model) {
		model.addAttribute("user", new User());
        model.addAttribute("desig", dservice.getAll());
        return "add";
    }
	@PostMapping("/save")
	public String save(User user,Model model)
	{
		if(!valid.validName(user.getUsername()))
		{
			model.addAttribute("error","Invalid name");
			model.addAttribute("desig", dservice.getAll());
			if(user.getId()!=null)
				return "update";
			return "add";
		}
		if(!valid.validMail(user.getEmail()))
		{
			model.addAttribute("error","Invalid EmailId");
			model.addAttribute("desig", dservice.getAll());
			if(user.getId()!=null)
				return "update";
			return "add";
		}
		if(!valid.validPhone(user.getPhno()))
		{
			model.addAttribute("error","Invalid Phone Number");
			model.addAttribute("desig", dservice.getAll());
			if(user.getId()!=null)
				return "update";
			return "add";
		}
		service.save(user);
		return "redirect:/";
	}
	
//	Update
	@GetMapping("/update")
	public String updatePage(@RequestParam(name =  "id",required = false) Integer id,Model model)
	{
		if(id==null)
		{
			model.addAttribute("error", "Please Select A User first!");
			model.addAttribute("users", service.getAll());
			return "home";
		}
		User user = urepo.findById(id).orElse(null);
		model.addAttribute("user",user);
		model.addAttribute("desig", dservice.getAll());		
		return "update";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam(name = "id",required = false) Integer id,Model model)
	{
		if(id==null)
		{
			model.addAttribute("error", "Please Select A User first");
			model.addAttribute("users", service.getAll());
			return "home";
		}
		service.delete(id);
		return "redirect:/";
	}
}
