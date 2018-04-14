package com.example.springbootkafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerMain {


    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "localhost:9092");

        properties.put("key.serializer", StringSerializer.class);

        properties.put("value.serializer", StringSerializer.class);

        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("zou1", 0, "message", "hello");


        Future<RecordMetadata> future = kafkaProducer.send(producerRecord);


        RecordMetadata recordMetadata = future.get();

        System.out.println(recordMetadata);

    }
}





































