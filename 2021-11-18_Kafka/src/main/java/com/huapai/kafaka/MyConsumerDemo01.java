package com.huapai.kafaka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/18.
 * 消费者
 */
public class MyConsumerDemo01 {

    /**
     * 1.声明主题
     */
    private final static String TOPIC_NAME = "my-replicated-topic";
    
    private final static String GROUP_ID = "my-group-1";

    public static void main(String[] args) {
        // 2.封装消费者的参数
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.148.143:9092,192.168.148.143:9093,192.168.148.143:9094");
        // 封装消费组的信息
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        
        // 封装 key value 的序列化器
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // consumer给broker发送心跳的间隔时间
        properties.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 1000);

        // kafka如果超过10秒没有收到收费者的心跳，则会把消费者提出消费组，进行 rebalance，把分区分配给其他消费者
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10 * 1000);

        // 一次 poll 最大拉取数消息的条数
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 500);
        
        // 如果两次 poll 的时间超过了 30s 的间隔，kafka 会认为其消费能力过弱，将其提出消费组，将分区分配给其他消费者 -rebalance
        properties.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 30 * 1000);
        
        // 是否自动提交 offerset，默认是true
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        
        // 自动提交 offerset 的时间间隔
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        
        // 3.创建消费者对象
        KafkaConsumer<String,String > consumer = new KafkaConsumer<>(properties);
        
        // 4.消费者订阅主题
//        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        
        // 消费指定分区
//        consumer.assign(Arrays.asList(new TopicPartition(TOPIC_NAME, 1)));
        // 消费最开始的消息
//        consumer.assign(Arrays.asList(new TopicPartition(TOPIC_NAME, 0)));
//        consumer.seekToBeginning(Arrays.asList(new TopicPartition(TOPIC_NAME, 0)));
        
        // 指定offset消费
//        consumer.assign(Arrays.asList(new TopicPartition(TOPIC_NAME, 0)));
//        consumer.seek(new TopicPartition(TOPIC_NAME,0),3);
        
        // 从指定时间点开始消费
        List<PartitionInfo> partitionInfos = consumer.partitionsFor(TOPIC_NAME);
        // 从一个小时前开始消费
        long fetchDataTime = System.currentTimeMillis() - 1000 * 60 * 60;
        Map<TopicPartition, Long> map = new HashMap<>();
        for (PartitionInfo partitionInfo : partitionInfos) {
            map.put(new TopicPartition(TOPIC_NAME, partitionInfo.partition()), fetchDataTime);
        }
        // consumer.offsetForTimes(map) 根据指定的时间找到分区中相应的消息的偏移量
        Map<TopicPartition, OffsetAndTimestamp> parMap = consumer.offsetsForTimes(map);
        for (Map.Entry<TopicPartition, OffsetAndTimestamp> entry : parMap.entrySet()) {
            TopicPartition key = entry.getKey();
            OffsetAndTimestamp value = entry.getValue();
            if (key == null || value == null) {
                continue;
            }
            Long offset = value.offset();
            System.out.println("partition-" + key.partition() + "|offset-" + offset);
            System.out.println();
            //根据消费里的timestamp确定offset
            if (value != null) {
                consumer.assign(Arrays.asList(key));
                consumer.seek(key, offset);
            }
        }

        // 5.kafka
        while (true) {
            /*
            poll() API 是拉取消息的长轮询
             */
            ConsumerRecords<String ,String > records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("收到消息：partition = %d,offset = %d, key = %s, value = %s%n", record.partition(),
                        record.offset(), record.key(), record.value());
            }
            
            // 手动同步提交offset，当前线程会阻塞知道offset提交成功
            // 一般使用同步提交，因为提交后一般也没什么逻辑代码了
            /*if (records.count() > 0) {
                consumer.commitSync();
            }*/
            
            // 手动异步提交offset，当前线程提交offset不会阻塞，可以继续处理后面的程序逻辑
            if (records.count() > 0) {
                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {
                        if (exception != null) {
                            System.err.println("Commit failed for " + offsets);
                            System.err.println("Commit failed exception: " + exception.getStackTrace());
                        }
                    }
                });
            }
            
        }
    }
    
}
