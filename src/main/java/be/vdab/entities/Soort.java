package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "soorten")
public class Soort implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	@Id
	@GeneratedValue
	private Long soortNr;
	
	@NotNull
	private String naam;
	
	@NotNull
	@OneToMany(mappedBy = "soort")
	private Set<Bier> bieren;
	
	protected Soort() {
	}
	
	/*
	 * setters voor variabelen
	 */
	public Long getSoortNr() {
		return soortNr;
	}

	public String getNaam() {
		return naam;
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
	
	public void setBieren(Set<Bier> bieren) {
		this.bieren = bieren;
	}

	
	/*
	 * to string method geeft waarden van variabelen terug ter info
	 */

	@Override
	public String toString() {
		return "soort [soortNr=" + soortNr + ", naam=" + naam + "]";
	}

	/* 
	 * hashcode and equals methode
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
		Soort other = (Soort) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
	
	
}
