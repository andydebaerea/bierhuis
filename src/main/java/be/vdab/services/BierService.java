package be.vdab.services;

import be.vdab.entities.Bier;

public interface BierService {
	long findAantalBieren();
	
	Bier read(long bierNr);
}
