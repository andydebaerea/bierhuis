package be.vdab.services;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	Iterable<Brouwer> findAll();

	Brouwer read(long id);
}
