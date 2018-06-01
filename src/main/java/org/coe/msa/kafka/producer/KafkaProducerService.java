package org.coe.msa.kafka.producer;


import org.coe.msa.kafka.channel.KafkaCustomSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(KafkaCustomSource.class)
public class KafkaProducerService {

    private KafkaCustomSource source;

    public KafkaProducerService(KafkaCustomSource source) {
        this.source = source;
    }

    @SendTo(KafkaCustomSource.TEST_SOURCE)
    public String send() {

        String message = "Hello World!!";

        // TODO Spring cloud strema Kafka에서 message 보내는 메서드 재확인
        source.testSource().send(MessageBuilder.withPayload(message).build());

        return message;
    }
}
