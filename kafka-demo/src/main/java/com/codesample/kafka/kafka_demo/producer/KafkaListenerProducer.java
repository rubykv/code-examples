package com.codesample.kafka.kafka_demo.producer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import com.codesample.kafka.kafka_demo.model.Account;
import com.codesample.kafka.kafka_demo.model.AccountEvent;
import com.google.gson.Gson;

@Service
public class KafkaListenerProducer {
	private final static String TOPIC = "<your kafka topic name here>";
    private final static String BOOTSTRAP_SERVERS = "<kafka server and port details>";
    
    public static Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "12345");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    public static void runConsumer() throws InterruptedException {
        Producer<String, String> producer = createProducer();
        AccountEvent event = new AccountEvent();
        event.setId("1003380642");
        Account acc = new Account();
        acc.setId("1a");
        acc.setAccountNumber("123456");
        Gson gsonString = new Gson();
        String serializedPayload = gsonString.toJson(acc, Account.class);
        event.setPayload(serializedPayload);
        String serializedJ = gsonString.toJson(event, AccountEvent.class);
        System.out.println("Output message "  +  serializedJ);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC,
                serializedJ);
        try {
            RecordMetadata metadata = producer.send(record).get();
            System.out.println("Record sent with key " + Math.random() + " to partition " + metadata.partition()
                    + " with offset " + metadata.offset());
        } catch (ExecutionException e) {
            System.out.println("Error in sending record");
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println("Error in sending record");
            System.out.println(e);
        }
        System.out.println("DONE");
    }
}
