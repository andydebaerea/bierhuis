package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;
import be.vdab.valueobjects.BestelbonLijn;

@Controller
@RequestMapping("/bieren")
class BierController {
	private final BierService bierService;
	private final WinkelWagen winkelwagen;
	
	@Autowired
	public BierController(BierService bierService, WinkelWagen winkelWagen) {
		this.bierService = bierService;
		this.winkelwagen = winkelWagen;
	}
	
	@RequestMapping(value= "{bierNr}", method = RequestMethod.GET)
	ModelAndView read(@PathVariable long bierNr) {
		ModelAndView modelAndView = new ModelAndView("bieren/bier");
		modelAndView.addObject("bestelbonlijnForm", new bestelbonlijnForm());
		modelAndView.addObject("bier", bierService.read(bierNr));
		return modelAndView;
	}
	
	/*
	 * voegt na valideren van aantal. biernr en aantal aan winkelwagen toe
	 */
	@RequestMapping(value = "toevoegen/{bierNr}", params = "aantal")
	ModelAndView toevoegen(@PathVariable long bierNr,
			@Valid bestelbonlijnForm bestelbonlijnForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("bieren/bier");
			modelAndView.addObject("bier", bierService.read(bierNr));
			return modelAndView; 
		}
		winkelwagen.addItem(bierNr, bestelbonlijnForm.getAantal());
		return new ModelAndView("redirect:/winkelwagen/inhoud");
	}
}
