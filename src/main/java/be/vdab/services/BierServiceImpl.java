package be.vdab.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;

@Service
@Transactional(readOnly = true)
class BierServiceImpl implements BierService {
	private final BierDAO bierDAO;
	
	@Autowired
	BierServiceImpl(BierDAO bierDAO) {
		this.bierDAO = bierDAO;
	}
	
	@Override
	public long findAantalBieren() {
		return bierDAO.count();
	}

	@Override
	public Bier read(long bierNr) {
		return bierDAO.findOne(bierNr);
	}
	
	@Override
	public List<Bier> finditemsInWinkelWagen(Set<Long> bierNrs) {
		return bierDAO.findAll(bierNrs);
	}
}

