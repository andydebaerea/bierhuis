package be.vdab.web;

import java.math.BigDecimal;
import java.util.Set;

import be.vdab.valueobjects.BestelbonLijn;

public interface WinkelWagen {

	/*
	 * methode om bestelbonlijn toe te voegen aan de set bestelbonlijnen
	 */
	void addBestelbonlijn(BestelbonLijn bestelbonLijn);

	/*
	 * methode voor het berekenen van het totaal van de bestelbon
	 */
	BigDecimal getTotaalVanBestelBon();

	Set<BestelbonLijn> getBestelbonlijnen();

}