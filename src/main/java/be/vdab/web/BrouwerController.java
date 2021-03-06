package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private final BrouwerService brouwerService;

	@Autowired
	BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView("brouwers/brouwers", "brouwers",
				brouwerService.findAll());
	}
	
	@RequestMapping(value = "{brouwer}",method = RequestMethod.GET)
	ModelAndView findBierenFromBrouwer(@PathVariable Brouwer brouwer){
		return new ModelAndView("brouwers/bieren", "brouwer", brouwer);	
	}
}
