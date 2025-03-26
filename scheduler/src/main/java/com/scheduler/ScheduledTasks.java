package com.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.scheduler.model.Customer;
import com.scheduler.repo.CustomerRepo;

@Component
public class ScheduledTasks {
	
	@Autowired
	RestTemplate template;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    CustomerRepo repo;
    
    @Scheduled(fixedRate = 1000)
    public void scheduleTaskWithFixedRate() {
        List<Customer> list=repo.findByStatus("NEW");	
        if(!list.isEmpty()) {
        	logger.info("Schedule Task :: updating records :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        	for(Customer cust:list) {
        		cust.setStatus("INPROCESS");
        		repo.save(cust);
        	}
        	for(Customer cust:list) {
        		String url="http://localhost:5051/telco/smsc?account_id="+ cust.getAccountId()+"&mobile="+cust.getMobile()+"&message="+cust.getMessage();
        		ResponseEntity<Object> res=template.getForEntity(url, Object.class);
        	}
        }
        else {
        	logger.info("Schedule Task :: No new Customer record is found, all records are updated :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        }
    }

}
