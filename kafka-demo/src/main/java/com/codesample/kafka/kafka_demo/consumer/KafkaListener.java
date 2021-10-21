package com.codesample.kafka.kafka_demo.consumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Service;


@Service
public class KafkaListener {

	private final static String TOPIC = "<your kafka topic name here>";
    private final static String BOOTSTRAP_SERVERS = "kafka server and port details";

    private static Consumer<String, String> createConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "Your Unique Consumer Name<>");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // Create consumer using above properties
        final Consumer<String, String> consumer = new KafkaConsumer<>(props);
        // Subscribe to the topic.
        consumer.subscribe(Collections.singletonList(TOPIC));
        return consumer;
    }

    //To be Invoked from Main Class to read data from the topic
    public static void runConsumer() throws InterruptedException {
        final Consumer<String, String> consumer = createConsumer();
        final int giveUp = 100;
        int noRecordsCount = 0;
        while (true) {
            final ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);
            if (consumerRecords.count() == 0) {
                noRecordsCount++;
                if (noRecordsCount > giveUp)
                    break;
                else
                    continue;
            }
            consumerRecords.forEach(record -> {
                String kafkaData = record.value();
                String parsedString = kafkaData.substring(kafkaData.indexOf("{"), kafkaData.lastIndexOf("}") + 1);
                System.out.printf("Consumer Record:(%s)\n", parsedString);
            });
            consumer.commitAsync();
        }
        consumer.close();
        System.out.println("DONE");
    }
}
