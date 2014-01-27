package be.vdab.web;

import java.math.BigDecimal;
import java.util.Set;

import be.vdab.valueobjects.BestelbonLijn;

public interface WinkelWagen {

	/*
	 * methode om item toe te voegen aan de winkelwagen
	 */
	void addItem(long bierNr, int aatal);

	/*
	 * methode voor het berekenen van het totaal van de winkelwagen
	 */
	BigDecimal getTotaalVanWinkelmandje();

	Set<BestelbonLijn> getBestelbonlijnen();

}