package com.huapai.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/20.
 */
@Component
public class MyConsumer {

    /**
     * 接受topic中的消息
     */
    /*@KafkaListener(id = "1", topics = "my-replicated-topic", groupId = "my-group-2")
    public void process(ConsumerRecord record, Acknowledgment ack) {

        System.out.printf("收到消息：partition = %d,offset = %d, key = %s, value = %s%n", record.partition(),
                record.offset(), record.key(), record.value());
        //手动提交
        ack.acknowledge();
        
    }*/
    
    @KafkaListener(groupId = "testGroup", topicPartitions = {
            @TopicPartition(topic = "my-replicated-topic", partitions = {"0", "1"}),
            @TopicPartition(topic = "my-replicated-topic", partitions = "0",
             partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))
    }, concurrency = "3")
    public void listenGroup(ConsumerRecord<String ,String > record, Acknowledgment ack) {
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
        // 手动提交offset
        ack.acknowledge();
    }

}
