package com.prodapt.cycles.rent;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prodapt.cycles.repository.CycleRepository;
import com.prodapt.cycles.repository.UserRepository;

@Controller
public class CyclesController {
	private static int i=1;
	@Autowired
	private CycleRepository cycleRepository;
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/borrow")
	public String borrow(String cyclemodel, int quantity, Model model)
	{
		Cycle cycle = new Cycle();
		cycle.setModel(cyclemodel);
		cycle.setQuantity(quantity);
		cycle.setId(i);
		cycleRepository.UpdateBorrowedCycles(cycle.getId(), cycle.getModel(), cycle.getQuantity());
		cycleRepository.updateCycleQuantity(quantity, cyclemodel);
		i++;
		model.addAttribute("cycle", cycle);
		return "borrowSucess";
		
	}
	
	@GetMapping("/borrowform")
	public String borrowForm() {
		return "cycle";
	}
	
	@GetMapping("/checkCycles")
	public String checkCycles(Model model) {
		String st= "";
		String[] cyclesAvailable = cycleRepository.getAllAvailableCycles();
		for(String i: cyclesAvailable)
			st=st+i+"\n";
		System.out.println(st);
		model.addAttribute("cycles",st);
		return "cycle";
	}
	
	@GetMapping("/restock")
	public String restock()
	{
		return "login";
	}
	
	@GetMapping("/login")
	public String login(Model model, String uname, String upass )
	{
		System.out.println(uname);
		System.out.println(upass);
		int count = userRepository.findValidUser(uname, upass) ;
		if(count>0)
		{
			return "restock_form";
		}
		else
		{
			model.addAttribute("message","Login failed bro");
			return "login";
		}
	}
	
	@GetMapping("/removeCycles")
	public String removeCycles(Model model, int restockID)
	{
		cycleRepository.restockCyclesOfID(restockID);
		System.out.println(restockID);
		cycleRepository.clearCyclesOfID(restockID);
		model.addAttribute("message", "restock done");
		return "restock_form";
	}
	
	
	
	
}

