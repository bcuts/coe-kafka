package org.coe.msa.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaCustomProcessor {

    String LOG =  "log";
    String ERROR =  "error";

    @Input
    SubscribableChannel log();

    @Output
    MessageChannel error();
}
