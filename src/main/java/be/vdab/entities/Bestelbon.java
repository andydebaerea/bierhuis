package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;
import be.vdab.web.WinkelWagen;

@Entity
@Table(name = "bestelbonnen")
public class Bestelbon implements Serializable, WinkelWagen {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long bonNr;

	@NotNull
	@Size(min = 1, max = 50, message = "{Size.tekst}")
	private String naam;

	@Valid
	@Embedded
	private Adres adres;

	@ElementCollection
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bonNr"))
	private Set<BestelbonLijn> bestelbonLijnen = new LinkedHashSet<>();

	public Bestelbon() {
	}

	public Bestelbon(String naam, Adres adres) {
		setNaam(naam);
		setAdres(adres);
	}

	public Bestelbon(long bonNr, String naam, Adres adres) {
		setBonNr(bonNr);
		setNaam(naam);
		setAdres(adres);

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

	@Override
	public Set<BestelbonLijn> getBestelbonlijnen() {
		return Collections.unmodifiableSet(bestelbonLijnen);
	}

	/*
	 * setters
	 */

	public void setBonNr(long bonNr) {
		this.bonNr = bonNr;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public void setBestelbonLijnen(Set<BestelbonLijn> bestelbonLijnen) {
		this.bestelbonLijnen = bestelbonLijnen;
	}

	/*
	 * methode om bestelbonlijn toe te voegen aan de set bestelbonlijnen
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.vdab.entities.bestelbonInterface#addBestelbonlijn(be.vdab.valueobjects
	 * .BestelbonLijn)
	 */
	@Override
	public void addBestelbonlijn(BestelbonLijn bestelbonLijn) {
		bestelbonLijnen.add(bestelbonLijn);
	}

	/*
	 * methode voor het berekenen van het totaal van de bestelbon
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see be.vdab.entities.bestelbonInterface#getTotaalVanBestelBon()
	 */
	@Override
	public BigDecimal getTotaalVanBestelBon() {
		BigDecimal totaalVanBestelBon = BigDecimal.ZERO;
		for (BestelbonLijn bestelbonLijn : bestelbonLijnen) {
			totaalVanBestelBon = totaalVanBestelBon.add(bestelbonLijn
					.getTotaalPerLijn());

		}
		return totaalVanBestelBon;
	}

}
