package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "bieren")
public class Bier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long bierNr;

	@NotNull
	private String naam;

	@NotNull
	@NumberFormat(pattern = "#,##0")
	private BigDecimal Alcohol;

	@NotNull
	@NumberFormat(pattern = "#,##0")
	@Min(0)
	private BigDecimal prijs;

	@ManyToOne
	@JoinColumn(name = "soortNr")
	private Soort soort;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brouwerNr")
	private Brouwer brouwer;

	public Bier() {
	}

	/*
	 * getters voor variabelen
	 */
	public Long getBierNr() {
		return bierNr;
	}

	public String getNaam() {
		return naam;
	}

	public BigDecimal getAlcohol() {
		return Alcohol;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public Soort getSoort() {
		return soort;
	}

	public Brouwer getBrouwer() {
		return brouwer;
	}

	/*
	 * setters voor variabelen
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAlcohol(BigDecimal alcohol) {
		Alcohol = alcohol;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public void setSoort(Soort soort) {
		this.soort = soort;
	}

	public void setBrouwer(Brouwer brouwer) {
		this.brouwer = brouwer;
	}

	/*
	 * tostring method geeft info over bier
	 */
	@Override
	public String toString() {
		return "Bier [bierNr=" + bierNr + ", naam=" + naam + ", Alcohol="
				+ Alcohol + ", prijs=" + prijs + ", soort=" + soort
				+ ", brouwer=" + brouwer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Alcohol == null) ? 0 : Alcohol.hashCode());
		result = prime * result + ((brouwer == null) ? 0 : brouwer.hashCode());
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
		Bier other = (Bier) obj;
		if (Alcohol == null) {
			if (other.Alcohol != null)
				return false;
		} else if (!Alcohol.equals(other.Alcohol))
			return false;
		if (brouwer == null) {
			if (other.brouwer != null)
				return false;
		} else if (!brouwer.equals(other.brouwer))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

}
