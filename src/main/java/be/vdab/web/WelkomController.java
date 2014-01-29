package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;


@Controller
@RequestMapping("/")
class WelkomController {
	private final BierService bierService;
	
	@Autowired
	WelkomController(BierService bierService) {
		this.bierService = bierService;
	}
	
	@RequestMapping
	String index() {
		return "redirect:/welkom";
	}
	
	@RequestMapping("welkom")
	ModelAndView welkom() {
		return new ModelAndView("/welkom", "totaalAantalBieren", bierService.findAantalBieren());
	}
}
