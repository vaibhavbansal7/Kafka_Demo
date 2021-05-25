package com.vaibhav;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Consumer {
    

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "StudentResultConsumer");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9091,localhost:9092,localhost:9093");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, User_Deserializer.class);
        props.put(User_Deserializer.VALUE_CLASS_NAME_CONFIG,StudentModel.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"StudentResultConsumerGroup");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        KafkaConsumer<String,StudentModel> consumer = new KafkaConsumer<String, StudentModel>(props);
        consumer.subscribe(Arrays.asList("student"));

        while(true){
            ConsumerRecords<String,StudentModel> records= consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String,StudentModel> record:records){
                System.out.println(record.value().getName());
            }
        }


    }
}