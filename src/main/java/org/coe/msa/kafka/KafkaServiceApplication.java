package org.coe.msa.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.coe.msa.kafka.producer.KafkaProducerService;

@SpringBootApplication
@RestController
public class KafkaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaServiceApplication.class, args);
	}

	@Autowired
	private KafkaProducerService producer;

	@RequestMapping("/kafka")
	public String send() {
		producer.send();
		return "Success";
	}
}
