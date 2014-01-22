package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "Brouwers")
public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long brouwerNr;
	
	@NotNull
	@Size(min = 1, max = 50, message = "{Size.tekst}")
	private String naam;
	
	@Embedded
	private Adres adres;
	
	@OneToMany(mappedBy = "brouwer", fetch = FetchType.EAGER)
	private Set<Bier> bieren;
	
	protected Brouwer(){
		
	}
	
	public Brouwer(String naam, Adres adres, Set<Bier> bieren) {
		this.naam = naam;
		this.adres = adres;
		this.bieren = bieren;
	}


	/*
	 * getters voor variabelen
	 */
	public Long getBrouwerNr() {
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
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
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
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
	
	
}
