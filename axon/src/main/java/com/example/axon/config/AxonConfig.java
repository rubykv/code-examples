package com.example.axon.config;

import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.extensions.mongo.DefaultMongoTemplate;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class AxonConfig {

	@Bean
	public MongoClient mongoClient(){
		 MongoClient mongoClient = new MongoClient("localhost", 27017);
		 return mongoClient;

	}
	
	// The `MongoEventStorageEngine` stores each event in a separate MongoDB document
	@Bean
	public EventStorageEngine storageEngine(MongoClient client) {
	    return MongoEventStorageEngine.builder().mongoTemplate(DefaultMongoTemplate.builder().mongoDatabase(client).build()).build();
	}

	// The Event store `EmbeddedEventStore` delegates actual storage and retrieval of events to an `EventStorageEngine`.
	@Bean
	public EmbeddedEventStore eventStore(EventStorageEngine storageEngine, AxonConfiguration configuration) {
	    return EmbeddedEventStore.builder()
	            .storageEngine(storageEngine)
	            .messageMonitor(configuration.messageMonitor(EventStore.class, "eventStore"))
	            .build();
	}
}
