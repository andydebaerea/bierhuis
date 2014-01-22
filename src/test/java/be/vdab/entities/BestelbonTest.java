package be.vdab.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import be.vdab.valueobjects.BestelbonLijn;

public class BestelbonTest {
	private Bier bier1, bier2;
	private Set<BestelbonLijn> bestelbonLijnen;
	private Bestelbon bestelbon;

	@Before
	public void before() {
		bier1 = new Bier();
		bier1.setPrijs(new BigDecimal(5));
		bier2 = new Bier();
		bier2.setPrijs(new BigDecimal(10));
		bestelbonLijnen = new HashSet<>();
		bestelbonLijnen.add(new BestelbonLijn(2, bier1));
		bestelbonLijnen.add(new BestelbonLijn(1, bier2));
		bestelbon = new Bestelbon();
		bestelbon.setBestelbonLijnen(bestelbonLijnen);
	}

	@Test
	public void GetTotaalVanBestelBonGivesRightTotal() {
		assertEquals(0, new BigDecimal(20).compareTo(bestelbon.getTotaalVanBestelBon()));
	}
}
