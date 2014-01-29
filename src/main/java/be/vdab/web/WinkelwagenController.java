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
class WinkelwagenController {
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


	/*
	 * validatie van bestelbon en bestelbon aanmaken
	 */
	@RequestMapping(value = "bevestigen", method = RequestMethod.POST)
	String Bevestigen(@Valid Bestelbon bestelbon, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		itemsVanWinkelwagenOverbrengenNaarBestelbon(bestelbon);
		if (bindingResult.hasErrors() || winkelwagen.getItems().isEmpty()) {
			return "winkelwagen/inhoud";
		}
		bestelbonService.create(bestelbon);
		winkelwagen.winkelwagenLedigen();
		redirectAttributes.addAttribute("bonNr", bestelbon.getBonNr());
		return "redirect:/winkelwagen/bevestigd/{bonNr}";
	}

	/*
	 * toont de inhoud van het winkelwagentje
	 */
	@RequestMapping(value = "inhoud", method = RequestMethod.GET)
	ModelAndView display() {
		ModelAndView modelAndView = new ModelAndView("winkelwagen/inhoud");
		Bestelbon bestelbon = new Bestelbon();
		if (!winkelwagen.getItems().isEmpty()) {
			itemsVanWinkelwagenOverbrengenNaarBestelbon(bestelbon);
		} else {
			modelAndView.addObject("fout", "geen artikelen in mandje");
		}
		modelAndView.addObject("bestelbon", bestelbon);
		return modelAndView;
	}

	/*
	 * kassa brengt art. van winkelwagen naar bestelbon
	 */
	private Bestelbon itemsVanWinkelwagenOverbrengenNaarBestelbon(
			Bestelbon bestelbon) {
		bierService.finditemsInWinkelWagen(winkelwagen.getItems().keySet());
		for (Map.Entry<Long, Integer> item : winkelwagen.getItems().entrySet()) {
			int aantal = item.getValue();
			Bier bier = bierService.read(item.getKey());
			bestelbon.addBestelbonlijn(new BestelbonLijn(aantal, bier));
		}
		return bestelbon;
	}

	/*
	 * bon is bevestigd door @WinkelwagenContoller.Bevestigen deze methode heeft
	 * bonNr teug aan jsp
	 */
	@RequestMapping(value = "bevestigd/{bonNr}")
	ModelAndView Bonbevestigd(@PathVariable Long bonNr) {
		return new ModelAndView("winkelwagen/bevestigd");
	}
}
