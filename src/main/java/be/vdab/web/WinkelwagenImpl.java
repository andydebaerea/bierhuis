package be.vdab.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class WinkelwagenImpl implements WinkelWagen, Serializable{
	private static final long serialVersionUID = 1L;
	private Map<Long, Integer> items = new HashMap<Long, Integer>();


	@Override
	public Map<Long, Integer> getItems() {
		return items;
	}

	@Override
	public void addItem(long bierNr, int aatal) {
		items.put(bierNr, aatal);
		
	}

}
