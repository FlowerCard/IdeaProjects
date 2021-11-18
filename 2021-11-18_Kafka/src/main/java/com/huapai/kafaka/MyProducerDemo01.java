package com.huapai.kafaka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/18.
 * Kafka 生产者实现
 */
public class MyProducerDemo01 {

    /**
     * 1.声明主题
     */
    private final static String TOPIC_NAME = "my-replicated-topic";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 2.封装参数
        Properties properties = new Properties();
        
        // 2.1 设置服务器集群地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.148.143:9092,192.168.148.143:9093,192.168.148.143:9094");
        
        // 2.2 把发送的 key 从字符串序列化为字节数组
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 把发送消息 value 从字符串转为字节数组
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        
        // 3.创建生产者
        Producer<String ,String> producer = new KafkaProducer<String, String>(properties);
        
        // 4.创建消息对象
//        ProducerRecord<String ,String > producerRecord = new ProducerRecord<>(TOPIC_NAME, "myRecordKey", "helloKafka");
        
        // 5.用生产者发送消息，获得消息记录信息
        // 同步发送
        /*RecordMetadata metadata = producer.send(producerRecord).get();

        System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-" + metadata.partition() +
                "|offset-" + metadata.offset());
        */
        
        /*
         发送失败会重试，默认重试间隔 100ms，重试能保证消息发送的可靠性，但是也可能造成消息重新发送，比如网络波动，所以需要在接受者那边
         做好消息接收的幂等性处理
         */
        properties.put(ProducerConfig.RETRIES_CONFIG, 3);
        // 重试间隔设置
        properties.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
        
        // 设置发送消息的本地缓冲区，如果设置了该缓冲区，消息会先发到本地缓冲区，可以提高消息发送性能，默认值是33554432，即32MB
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        
        /*
            kafka 本地线程会从缓冲区取数据，批量发送到 broker
            设置批量发送消息的大小，默认值是16384，即16kb，就是说一个batch满了16kb就发送出去
         */
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        
        /*
            默认值是0，意思就是消息必须立即被发送出去，但这样会影响性能
            一般设置10毫秒左右，就是说这个消息发送完成会进入一个本地batch，如果10毫秒内，这个batch满了16kb就会随batch一起被发送出去，如果10毫秒内batch没满，
            那么也必须把消息发出去，不能让消息的发送延迟时间太长
         */
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 10);

        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            // 创建消息对象
            ProducerRecord<String ,String > producerRecord = new ProducerRecord<>(TOPIC_NAME, "myRecordKey" + i, "helloKafka");

            //异步发送：不去调用get(),但是怎么获得这一次发送的结果呢？可以通过Callback对象里面的onCompletion()来提供给kafka的回调，能得到这一次发送的结果
            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    // 消息发送失败了
                    if (Objects.nonNull(exception)) {
                        System.out.println(exception.getMessage());
                        return;
                    }
                    
                    // 消息发送成功
                    System.out.println("异步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
                            + metadata.partition() + "|offset-" + metadata.offset());
                    countDownLatch.countDown();
                }
            });
        }
        
        producer.close();
        
    }
    
}
