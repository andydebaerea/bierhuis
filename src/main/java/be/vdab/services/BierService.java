package be.vdab.services;

import java.util.List;
import java.util.Set;

import be.vdab.entities.Bier;

public interface BierService {
	long findAantalBieren();
	
	Bier read(long bierNr);

	List<Bier> finditemsInWinkelWagen(Set<Long> bierNrs);
}
