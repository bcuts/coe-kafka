package org.coe.msa.kafka.processor;


import org.coe.msa.kafka.Sample;
import org.coe.msa.kafka.channel.KafkaCustomProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(KafkaCustomProcessor.class)
public class KafkaProcessorService {




    private KafkaCustomProcessor processor;

    public KafkaProcessorService(KafkaCustomProcessor processor) {
        this.processor = processor;
    }

    @StreamListener(KafkaCustomProcessor.LOG)
    @SendTo(KafkaCustomProcessor.ERROR)
    public Sample receviceAndSend(String log) {

        // TODO Spring cloud strema Kafka에서 message 보내는 메서드 재확인
        Sample s = new Sample(log);
        if(log.contains("[ERROR]")) {
            processor.error().send(MessageBuilder.withPayload(s).build());
        }
        return null;
    }
}
