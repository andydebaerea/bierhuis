package be.vdab.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import be.vdab.valueobjects.BestelbonLijn;

public class BestelbonTest {
	private Bier bier1;
	private Set<BestelbonLijn> bestelbonLijnen;
	private Bestelbon bestelbon;

	@Before
	public void before() {
		bier1 = new Bier();
		bier1.setPrijs(new BigDecimal(5));
		bestelbonLijnen = new HashSet<>();
		bestelbonLijnen.add(new BestelbonLijn(2, bier1));
		bestelbon = new Bestelbon();
		bestelbon.setBestelbonLijnen(bestelbonLijnen);
	}

	@Test
	public void getTotaalVanBestelBonGivesRightTotal() {
		assertEquals(0, new BigDecimal(10).compareTo(bestelbon.getTotaalVanBestelBon()));
	}
}
