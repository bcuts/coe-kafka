package org.coe.msa.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaCustomSink {

    String TEST_SINK = "testSink";

    @Input
    SubscribableChannel testSink();

}
