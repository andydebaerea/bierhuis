package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.BestelbonLijn;

@Controller
@RequestMapping("/winkelwagen")
public class WinkelwagenController {
	private final BierService bierService;
	private final BestelbonService bestelbonService;
	private WinkelWagen winkelwagen;
	

	@Autowired
	public WinkelwagenController(BierService bierService,
			WinkelWagen winkelWagen, BestelbonService bestelbonService) {
		this.bierService = bierService;
		this.winkelwagen = winkelWagen;
		this.bestelbonService = bestelbonService;
	}

	@RequestMapping(value = "toevoegen/{bierNr}", params = "aantal")
	ModelAndView toevoegen(@PathVariable Long bierNr, int aantal) {
		winkelwagen.addBestelbonlijn(new BestelbonLijn(aantal, bierService
				.read(bierNr)));
		return ObjectenToevoegenAanModelAndView();
	}

	@RequestMapping(value = "inhoud", method = RequestMethod.GET)
	ModelAndView display() {
		return ObjectenToevoegenAanModelAndView();
	}
	
	@RequestMapping(value = "bevestigen", method = RequestMethod.POST)
	ModelAndView Bevestigen(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ObjectenToevoegenAanModelAndView();
		}
		for (BestelbonLijn bestelbonLijn : winkelwagen.getBestelbonlijnen()) {
			bestelbon.addBestelbonlijn(bestelbonLijn);
		}
		bestelbonService.create(bestelbon);
		return new ModelAndView("winkelwagen/bevestigd");
	}
	
	private ModelAndView ObjectenToevoegenAanModelAndView() {
		ModelAndView modelAndView = new ModelAndView("winkelwagen/inhoud");
		modelAndView.addObject("winkelwagen", winkelwagen);
		modelAndView.addObject("bestelbon", new Bestelbon());
		return modelAndView;
	}
}
