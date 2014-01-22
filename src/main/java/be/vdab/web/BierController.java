package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;

@Controller
@RequestMapping("/bieren")
public class BierController {
	private final BierService bierService;
	
	@Autowired
	public BierController(BierService bierService) {
		this.bierService = bierService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView read() {
		return new ModelAndView("bieren/bier");
		// TODO 
	}
}
