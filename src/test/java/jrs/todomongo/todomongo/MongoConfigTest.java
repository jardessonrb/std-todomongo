package jrs.todomongo.todomongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@TestConfiguration
public class MongoConfigTest {
    
    private static final String CONNECTION_URL = "mongodb://%s:%d";

    @Value("$spring.data.mongodb.host")
    String host;

    @Value("$spring.data.mongodb.port")
    int port;

    @Bean
    public MongoTemplate mongoTemplate() {
        final MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create(String.format(CONNECTION_URL, host, port)), CONNECTION_URL);

        return mongoTemplate;
    }

    // public MongoClient 
}
