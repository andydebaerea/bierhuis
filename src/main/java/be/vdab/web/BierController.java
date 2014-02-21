package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;
@Controller
@RequestMapping("/bieren")
class BierController {
	private final WinkelWagen winkelwagen;
	
	@Autowired
	public BierController(WinkelWagen winkelWagen) {
		this.winkelwagen = winkelWagen;
	}
	
	@RequestMapping(value= "{bier}", method = RequestMethod.GET)
	ModelAndView read(@PathVariable Bier bier) {
		ModelAndView modelAndView = new ModelAndView("bieren/bier");
		modelAndView.addObject("bestelbonlijnForm", new bestelbonlijnForm());
		modelAndView.addObject("bier", bier);
		return modelAndView;
	}
	
	/*
	 * voegt na valideren van aantal. biernr en aantal aan winkelwagen toe
	 */
	@RequestMapping(value = "toevoegen/{bier}", params = "aantal")
	ModelAndView toevoegen(@PathVariable Bier bier,
			@Valid bestelbonlijnForm bestelbonlijnForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("bieren/bier");
			modelAndView.addObject("bier", bier);
			return modelAndView; 
		}
		winkelwagen.addItem(bier.getBierNr(), bestelbonlijnForm.getAantal());
		return new ModelAndView("redirect:/winkelwagen/inhoud");
	}
}
