package com.customer.service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.customer.binding.Customer;
import com.customer.contants.AppConstants;
import com.customer.exception.Data;

@Service
public class CustomerService {

    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    public ResponseEntity<Object> addMsg(Customer customer) {
        // publish msg to kafka topic
    	Message<Customer> message= MessageBuilder
                .withPayload(customer)
                .setHeader(TOPIC,AppConstants.TOPIC_NAME).build();
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message.getPayload());
        
        Data data=new Data("SUCCESS",null);
        return new ResponseEntity<Object>(data,HttpStatus.ACCEPTED);
    }
}
