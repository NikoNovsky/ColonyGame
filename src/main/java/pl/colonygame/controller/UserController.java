package pl.colonygame.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.colonygame.entity.User;
import pl.colonygame.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/user")
	public String userList(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);

		return "user/list";
	}

	@GetMapping("user/add")
	public String userForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/form";

	}

	@PostMapping("user/add")
	public String userFormSubmit(@ModelAttribute User user) {
		userRepository.save(user);
		return "redirect:/user";

	}
	
	@GetMapping("/user/update/{id}")
	public String editUserForm(Model model, @PathVariable int id) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "user/formedit";
	}

	@PostMapping("/user/update/{id}")
	public String editUserSucces(@ModelAttribute User user) {
		userRepository.save(user);
		return "redirect:/user";
	}
	
	@GetMapping("/user/delete/{id}")
	public String userDelete(@PathVariable int id) {
		User user = userRepository.findOne(id);
		userRepository.delete(user);

		return "redirect:/user";
	}
}
