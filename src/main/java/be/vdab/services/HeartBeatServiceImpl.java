package be.vdab.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

public class HeartBeatServiceImpl implements HeartBeatService {
	private final RestTemplate restTemplate = new RestTemplate();
	
	@Override
	@Scheduled(fixedRate=60000)
	public void sendHeartBeat() {
		restTemplate.getForObject("http://bierhuis.andydeb.cloudbees.net", String.class);
	}
}
