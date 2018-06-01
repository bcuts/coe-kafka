package org.coe.msa.kafka.consumer;

import org.coe.msa.kafka.channel.KafkaCustomSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(KafkaCustomSink.class)
public class KafkaConsumerService {

    private KafkaCustomSink sink;

    KafkaConsumerService(KafkaCustomSink sink){
        this.sink = sink;
    }

    @StreamListener(KafkaCustomSink.TEST_SINK)
    public  void receive(String message) {
        System.out.println(message);
    }
}
