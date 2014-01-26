package be.vdab.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
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

	@Override
	public void addBestelbonlijn(BestelbonLijn bestelbonLijn) {
		bestelbonLijnen.add(bestelbonLijn);
		
	}

	@Override
	public BigDecimal getTotaalVanBestelBon() {
		BigDecimal totaalVanBestelBon = BigDecimal.ZERO;
		for (BestelbonLijn bestelbonLijn : bestelbonLijnen) {
			totaalVanBestelBon = totaalVanBestelBon.add(bestelbonLijn
					.getTotaalPerLijn());
		}
		return totaalVanBestelBon;
	}

	@Override
	public Set<BestelbonLijn> getBestelbonlijnen() {
		return bestelbonLijnen;
	}

}
