package com.timepass.funny.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.timepass.funny.entity.User;

import com.timepass.funny.binding.Word;
import com.timepass.funny.model.RegistrationForm;
import com.timepass.funny.repository.UserMessageRepository;
import com.timepass.funny.service.DomainUserService;
@Controller
@RequestMapping("/funny")
public class FunnyController {
	@Autowired
	  private DomainUserService domainUserService;
	@Autowired
	private UserMessageRepository userMessageRepository;
	
	  @GetMapping("/register")
	  public String getRegistrationForm(Model model) {
	    if (!model.containsAttribute("registrationForm")) {
	      model.addAttribute("registrationForm", new RegistrationForm());
	    }
	    return "fun/register";
	  }
	  
	  @PostMapping("/register")
	  public String register(@ModelAttribute("registrationForm") RegistrationForm registrationForm, 
	  BindingResult bindingResult, 
	  RedirectAttributes attr) {
	    if (bindingResult.hasErrors()) {
	      attr.addFlashAttribute("org.springframework.validation.BindingResult.registrationForm", bindingResult);
	      attr.addFlashAttribute("registrationForm", registrationForm);
	      return "redirect:funny/register";
	    }
	    if (!registrationForm.isValid()) {
	      attr.addFlashAttribute("message", "Passwords must match");
	      attr.addFlashAttribute("registrationForm", registrationForm);
	      return "redirect:funny/register";
	    }
	    System.out.println(domainUserService.save(registrationForm.getUsername(), registrationForm.getPassword()));
	    attr.addFlashAttribute("result", "Registration success!");
	    return "redirect:/login";
	  }
	  
	  @GetMapping("/hello")
	  public String hello(Model model, @AuthenticationPrincipal UserDetails userDetails)
	  {
		  String name = userDetails.getUsername();
		  model.addAttribute("message",name);
		  return "fun/greet";
	  }
	  
	  @GetMapping("/content")
	  public String content(Model model, @AuthenticationPrincipal UserDetails userDetails)
	  {
		  Word word = new Word();
		  
		  User author = domainUserService.getByName(userDetails.getUsername()).get();
		  word.setUserId(author.getId());
		  model.addAttribute("word", word);
		  return "fun/wordForUs";
	  }
	  @GetMapping("/saveWord")
	  public String saveWord(Model model, @ModelAttribute("word") Word word, BindingResult br, RedirectAttributes attr)
	  {
		  if (br.hasErrors()) {
		      System.out.println(br.getFieldErrors());
		      attr.addFlashAttribute("org.springframework.validation.BindingResult.post", br);
		      attr.addFlashAttribute("word", word);
		      return "redirect:/funny/saveWord";
		    }
		  System.out.println(word.getUserId());
		  System.out.println(word.getWordContent());
		  System.out.println(word.getWordId());
		  userMessageRepository.save(word);
		  return "fun/getWords";
	  }
	  
	  
}
