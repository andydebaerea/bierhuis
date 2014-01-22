package be.vdab.valueobject;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.entities.Bier;
import be.vdab.valueobjects.BestelbonLijn;

public class BestelBonLijnTest {
	private Bier bier;
	private BestelbonLijn bestelbonLijn;

	@Before
	public void before() {
		bier = new Bier();
		bier.setPrijs(new BigDecimal(5));
		bestelbonLijn = new BestelbonLijn(2, bier);
	}
	@Test
	public void test() {
		assertEquals(0, new BigDecimal(10).compareTo(bestelbonLijn.getTotaalPerLijn()));
	}

}
