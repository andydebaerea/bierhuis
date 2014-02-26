package be.vdab.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HeartBeatServiceImpl implements HeartBeatService {
	private final RestTemplate restTemplate = new RestTemplate();
	
	@Override
	@Scheduled(fixedRate=60000)
	public void sendHeartBeat() {
		restTemplate.getForObject("http://bierhuis.andydeb.cloudbees.net", String.class);
		restTemplate.getForObject("http://cultuurhuis.andydeb.cloudbees.net", String.class);
	}
}
