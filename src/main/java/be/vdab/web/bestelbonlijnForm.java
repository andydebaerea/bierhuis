package be.vdab.web;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

class bestelbonlijnForm {
	
	@NotNull
	@Min(value = 1)
	private int aantal;
	
	bestelbonlijnForm() {
		
	}
	
	bestelbonlijnForm(int aantal) {
		this.aantal = aantal;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

}
