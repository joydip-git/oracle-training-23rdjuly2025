package com.oracle.kafkaproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.oracle.kafkaproducer.models.Employee;

@Configuration
public class KafkaProducerConfig {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;
	
	@Bean(name = "StringFactoryBean")
	ProducerFactory<String, String> producerFactory1(){
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);		
		return new DefaultKafkaProducerFactory<String, String>(configProps);
	}
	
	@Bean(name = "EmployeeFactoryBean")
	ProducerFactory<String, Employee> producerFactory2(){
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);		
		return new DefaultKafkaProducerFactory<String, Employee>(configProps);
	}
	
	@Bean(name = "StringTemplateBean")
	KafkaTemplate<String, String> kafkaTemplate1(){
		return new KafkaTemplate<String,String>(producerFactory1());
	}
	
	@Bean(name = "EmployeeTemplateBean")
	KafkaTemplate<String, Employee> kafkaTemplate2(){
		return new KafkaTemplate<String,Employee>(producerFactory2());
	}
}
