package be.vdab.entities;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "Brouwers")
public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long brouwerNr;

	private String naam;

	@Embedded
	@Valid
	private Adres adres;

	private Integer omzet;

	@OneToMany(mappedBy = "brouwer")
	private Set<Bier> bieren;

	public Brouwer() {

	}

	public Brouwer(String naam, Adres adres, Set<Bier> bieren) {
		this.naam = naam;
		this.adres = adres;
		this.bieren = new LinkedHashSet<>();
	}

	public Brouwer(long brouwerNr, String naam, Adres adres, Integer omzet) {
		setBrouwerNr(brouwerNr);
		setNaam(naam);
		setAdres(adres);
	}

	/*
	 * getters voor variabelen
	 */
	public long getBrouwerNr() {
		return brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public Set<Bier> getBieren() {
		return bieren;
	}

	/*
	 * setters voor variabelen
	 */
	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public void setBieren(Set<Bier> bieren) {
		this.bieren = bieren;
	}

	/*
	 * tostring method geeft waarden van brouwer terug
	 */
	@Override
	public String toString() {
		return "Brouwer [brouwerNr=" + brouwerNr + ", naam=" + naam
				+ ", adres=" + adres + "]";
	}

	/*
	 * hashcode en equals voor brouwer
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.toUpperCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brouwer other = (Brouwer) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equalsIgnoreCase(other.naam))
			return false;
		return true;
	}

}
