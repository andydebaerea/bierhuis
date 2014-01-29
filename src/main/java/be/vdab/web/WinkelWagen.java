package be.vdab.web;

import java.util.Map;

interface WinkelWagen {

	/*
	 * methode om item toe te voegen aan de winkelwagen
	 */
	void addItem(long bierNr, int aatal);

	/*
	 * methode voor teruggeven van de artikelen die in mandje aaanwezig zijn
	 */
	Map<Long, Integer> getItems();
	
	void winkelwagenLedigen ();

}