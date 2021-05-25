package com.vaibhav;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


import java.util.Properties;


public class Producer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,User_Serializer.class);


        KafkaProducer<String,StudentModel> producer=new KafkaProducer<String, StudentModel>(props);
        StudentModel student=new StudentModel(1,"Vaibhav","Cs");
        System.out.println("Producer has been created");
        ProducerRecord<String,StudentModel> record =new ProducerRecord<String,StudentModel>("student-info",student.getDept(),student);
        producer.send(record);
        System.out.println("Student object has been sent to Kafka");
        producer.close();

    }
}
