package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.vdab.entities.Bier;

@Embeddable
public class BestelbonLijn implements Serializable {
	private static final long serialVersionUID = 1L;

	private int aantal;

	@ManyToOne
	@JoinColumn(name = "bierNr")
	private Bier bier;

	protected BestelbonLijn() {
	}

	public BestelbonLijn(int aantal, Bier bier) {
		this.aantal = aantal;
		setBier(bier);

	}

	/*
	 * getters
	 */
	public int getAantal() {
		return aantal;
	}

	public Bier getBier() {
		return bier;
	}

	/*
	 * setters
	 */

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public void setBier(Bier bier) {
		this.bier = bier;
	}

	/*
	 * methode voor totaalprijs per bestelbonlijn uit te rekenen
	 */

	public BigDecimal getTotaalPerLijn() {
		return bier.getPrijs().multiply(new BigDecimal(aantal));
	}

	/*
	 * hachcode en equals op bier
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bier == null) ? 0 : bier.hashCode());
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
		BestelbonLijn other = (BestelbonLijn) obj;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}

}
