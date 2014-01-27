package be.vdab.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bier;
import be.vdab.services.BestelbonService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.BestelbonLijn;

@Controller
@RequestMapping("/winkelwagen")
public class WinkelwagenController {
	private final BierService bierService;
	private final BestelbonService bestelbonService;
	private final WinkelWagen winkelwagen;
	

	@Autowired
	public WinkelwagenController(BierService bierService,
			WinkelWagen winkelWagen, BestelbonService bestelbonService) {
		this.bierService = bierService;
		this.winkelwagen = winkelWagen;
		this.bestelbonService = bestelbonService;
	}

	@RequestMapping(value = "toevoegen/{bierNr}", params = "aantal")
	ModelAndView toevoegen(@PathVariable Long bierNr, int aantal, RedirectAttributes redirectAttributes) {
		
		winkelwagen.addItem(bierNr, aantal);
		return new ModelAndView("redirect:/winkelwagen/inhoud");
	}

	
	@RequestMapping(value = "bevestigen", method = RequestMethod.POST)
	ModelAndView Bevestigen(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			/*return ObjectenToevoegenAanModelAndView();
		}
		for (BestelbonLijn bestelbonLijn : winkelwagen.getItems()) {
			bestelbon.addBestelbonlijn(bestelbonLijn);*/
		}
		bestelbonService.create(bestelbon);
		return new ModelAndView("winkelwagen/bevestigd");
	}
	
	 @RequestMapping(value = "inhoud", method = RequestMethod.GET)
		ModelAndView display() {
		ModelAndView modelAndView = new ModelAndView("winkelwagen/inhoud");
		Bestelbon bestelbon = new Bestelbon();
		if (!winkelwagen.getItems().isEmpty()) {
			for (Map.Entry<Long, Integer> item : winkelwagen.getItems().entrySet()) {
				int aantal = item.getValue();
				Bier bier = bierService.read(item.getKey());
				bestelbon.addBestelbonlijn(new BestelbonLijn(aantal, bier));
				modelAndView.addObject("bestelbon", bestelbon);
			}
		} else {
			modelAndView.addObject("fout", "geen artikelen in mandje");
		}
		
		return modelAndView;
	}
}
