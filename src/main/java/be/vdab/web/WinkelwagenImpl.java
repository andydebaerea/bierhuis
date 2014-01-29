package be.vdab.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
class WinkelwagenImpl implements WinkelWagen, Serializable{
	private static final long serialVersionUID = 1L;
	private Map<Long, Integer> items = new HashMap<Long, Integer>();


	@Override
	public Map<Long, Integer> getItems() {
		return items;
	}

	@Override
	public void addItem(long bierNr, int aantal) {
		if (items.containsKey(bierNr)) {
			int newAantal = aantal + items.get(bierNr).intValue();
			items.remove(bierNr);
			items.put(bierNr, newAantal);
		} else {
			items.put(bierNr, aantal);
		}
	}
	
	@Override
	public void winkelwagenLedigen () {
		items.clear();
	}

}
