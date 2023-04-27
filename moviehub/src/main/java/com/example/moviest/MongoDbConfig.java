package com.example.moviest;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.moviest")
public class MongoDbConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Override
    protected String getDatabaseName() {
        return "movie_api_database";
    }
    @Override
    public MongoClient mongoClient() {
        // Configure and return the MongoClient using the MongoDB URI
        return MongoClients.create(mongoUri);
    }

    @Override
    protected boolean autoIndexCreation() {
        // Optionally configure auto-index creation
        return true;
    }
}