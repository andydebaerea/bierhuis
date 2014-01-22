package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BierDAO;

@Service
@Transactional(readOnly = true)
public class BierServiceImpl implements BierService {
	private final BierDAO bierDAO;
	
	@Autowired
	BierServiceImpl(BierDAO bierDAO) {
		this.bierDAO = bierDAO;
	}
	
	@Override
	public long findAantalBieren() {
		return bierDAO.count();
	}

}
