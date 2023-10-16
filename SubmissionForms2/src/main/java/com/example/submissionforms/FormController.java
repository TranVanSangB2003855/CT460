package com.example.submissionforms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/")
	public String edureka() {
		return "edureka";
	}
	
	@PostMapping("/details")
	public String viewdetails(Customers customers) {
		System.out.println(customers.toString());
		repo.save(customers);
		return "ViewCustomers";
	}
	
	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid) {/*just to search a customer by id*/
		ModelAndView mv= new ModelAndView("Retrieve");
		//Retrieve.jsp, we try to retrieve data from the database, and then display on the web page
		Customers customers =
		repo.findById(cid).orElse(null); //find by cid or cid is null
		mv.addObject(customers);
		return mv;
	}
}
