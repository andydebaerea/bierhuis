package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;

@Entity
@Table(name = "bestelbonnen")
public class Bestelbon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long bonNr;

	@NotNull
	private String naam;

	@Embedded
	private Adres adres;

	@ElementCollection
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bonNr"))
	private Set<BestelbonLijn> bestelbonLijnen;

	
	protected Bestelbon() {
	}

	public Bestelbon(String naam, Adres adres) {
		setNaam(naam);
		setAdres(adres);
		bestelbonLijnen = new HashSet<>();
	}

	public Bestelbon(Set<BestelbonLijn> bestelbonLijnen) {
		this.bestelbonLijnen = bestelbonLijnen;
	}

	/*
	 * getters
	 */

	public Long getBonNr() {
		return bonNr;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public Set<BestelbonLijn> getBestelbonlijnen() {
		return Collections.unmodifiableSet(bestelbonLijnen);
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	/*
	 * methode om bestelbonlijn toe te voegen aan de set bestelbonlijnen
	 */
	public void addBestelbonlijn(BestelbonLijn bestelbonLijn) {
		bestelbonLijnen.add(bestelbonLijn);
		if (bestelbonLijn.getBestelbon() != this)
			bestelbonLijn.setBestelBon(this);
	}

	/*
	 * methode voor het berekenen van het totaal van de bestelbon
	 */
	public BigDecimal getTotaalVanBestelBon() {
		BigDecimal totaalVanBestelBon = BigDecimal.ZERO;
		for (BestelbonLijn bestelbonLijn : bestelbonLijnen) {
			totaalVanBestelBon = totaalVanBestelBon.add(bestelbonLijn
					.getTotaalPerLijn());
		}
		return totaalVanBestelBon;
	}

}
