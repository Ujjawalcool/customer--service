package com.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.customer.binding.Customer;
import com.customer.config.CustomerRepo;
import com.customer.constants.KafkaConstants;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private CustomerRepo dataRepository;

    public KafkaDatabaseConsumer(CustomerRepo dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = KafkaConstants.TOPIC_NAME,
            groupId = "customer_first",containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(Customer customer){

    	customer.setStatus("NEW");
        LOGGER.info(String.format("Event message received -> %s", customer.getStatus()));

       

        dataRepository.save(customer);
    }
}
