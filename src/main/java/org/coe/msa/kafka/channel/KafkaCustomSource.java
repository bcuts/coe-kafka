package org.coe.msa.kafka.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaCustomSource {

    String TEST_SOURCE =  "testSource";

    @Output
    MessageChannel testSource();

}
