package be.vdab.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import be.vdab.valueobjects.BestelbonLijn;
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class WinkelwagenImpl implements WinkelWagen, Serializable{
	private static final long serialVersionUID = 1L;
	private Set<BestelbonLijn> bestelbonLijnen = new HashSet<>();
	private Map<Long, Integer> items = new HashMap<Long, Integer>();


	@Override
	public Set<BestelbonLijn> getBestelbonlijnen() {
		return bestelbonLijnen;
	}

	@Override
	public void addItem(long bierNr, int aatal) {
		items.put(bierNr, aatal);
		
	}

	@Override
	public BigDecimal getTotaalVanWinkelmandje() {
		// TODO Auto-generated method stub
		return null;
	}

}
