package springboot.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springboot.crud.entity.User;
import springboot.crud.repository.UserRepository;
import springboot.crud.service.DesignationService;
import springboot.crud.service.UserService;
import springboot.crud.validation.Validate;

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
	public String getAll(Model model) {
	    model.addAttribute("users", service.getAll());
	    return "home";
	}

//	Pagination
//	@GetMapping("/")
//	public String getAll(@RequestParam(defaultValue = "0") int page,Model model)
//	{
//		Page<User> usersPage=service.getPaginated(page, 4);
//		model.addAttribute("users", usersPage.getContent());
//		model.addAttribute("currentPage", page);
//		model.addAttribute("totalPages", usersPage.getTotalPages());
//		return "home";
//	}
	
//	Add Page
	@GetMapping("/addUser")
    public String addPage(Model model) {
		model.addAttribute("user", new User());
        model.addAttribute("desig", dservice.getAll());
        return "add";
    }
	@PostMapping("/save")
	public String save(User user,Model model,RedirectAttributes ra)
	{
//		if(!valid.validName(user.getUsername()))
//		{
//			model.addAttribute("error","Invalid name");
//			model.addAttribute("desig", dservice.getAll());
//			if(user.getId()!=null)
//				return "update";
//			return "add";
//		}
		if(!valid.validMail(user.getEmail()))
		{
			model.addAttribute("error","Invalid Email Id");
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
		ra.addFlashAttribute("msg", "Record Added Sucessfully");
		service.save(user);
		return "redirect:/";
	}
	
//	Update
	@GetMapping("/update")
	public String updatePage(@RequestParam(name =  "id",required = false) Integer id,@RequestParam(defaultValue = "0")int page,Model model,RedirectAttributes ra)
	{
		if(id==null)
		{
			ra.addFlashAttribute("error", "Please Select A User first!");
			return "redirect:/";
		}
		User user = urepo.findById(id).orElse(null);
		model.addAttribute("user",user);
		model.addAttribute("desig", dservice.getAll());		
		return "update";
	}
	
	@PostMapping("/updated")
	public String updated(User user,Model model,RedirectAttributes ra)
	{
//		if(!valid.validName(user.getUsername()))
//		{
//			model.addAttribute("error","Invalid name");
//			model.addAttribute("desig", dservice.getAll());
//			if(user.getId()!=null)
//				return "update";
//			return "add";
//		}
		if(!valid.validMail(user.getEmail()))
		{
			model.addAttribute("error","Invalid Email Id");
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
		ra.addFlashAttribute("msg", "Record Updated Sucessfully");
		service.save(user);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam(name = "id",required = false) Integer id,RedirectAttributes ra,@RequestParam(defaultValue = "0")int page)
	{
		if(id==null)
		{
			ra.addFlashAttribute("error","Please Select A User first!");
			return "redirect:/";
		}
		ra.addFlashAttribute("msg","Record Deleted Sucessfully");
		service.delete(id);
		return "redirect:/";
	}
}
