package com.huapai.consumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/19.
 */
@Component
public class MyConsumer {

    /**
     * 接收topic中的消息
     */
    @KafkaListener(id = "1", topics = "my-replicated-topic" , groupId = "my-group-4")
    public void process(ConsumerRecord record, Acknowledgment ack) {
        System.out.printf("收到消息：partition = %d,offset = %d, key = %s, value = %s%n", record.partition(),
                record.offset(), record.key(), record.value());
        //手动提交
        ack.acknowledge();
    }

}
