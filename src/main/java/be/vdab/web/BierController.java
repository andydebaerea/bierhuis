package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;
import be.vdab.valueobjects.BestelbonLijn;

@Controller
@RequestMapping("/bieren")
public class BierController {
	private final BierService bierService;
	
	@Autowired
	public BierController(BierService bierService) {
		this.bierService = bierService;
	}
	
	@RequestMapping(value= "{bierNr}", method = RequestMethod.GET)
	ModelAndView read(@PathVariable long bierNr) {
		ModelAndView modelAndView = new ModelAndView("bieren/bier");
		modelAndView.addObject("bestelbonlijn", new BestelbonLijn());
		modelAndView.addObject("bier", bierService.read(bierNr));
		return modelAndView;
	}
}
