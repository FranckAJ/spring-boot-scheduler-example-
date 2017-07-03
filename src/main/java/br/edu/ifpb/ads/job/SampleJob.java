package br.edu.ifpb.ads.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SampleJob {

	private static final Logger log = LoggerFactory.getLogger(SampleJob.class);

	@Value("${br.edu.scheduledJob.enabled}")
	private boolean scheduledJobEnabled;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * 
	 */
	@Scheduled(fixedRate = 5000)
	public void runSampleJob() {
		
		if(!scheduledJobEnabled){
			return;
		} 
		
		log.info("run job at " + dateFormat.format(new Date()));
	}
}
