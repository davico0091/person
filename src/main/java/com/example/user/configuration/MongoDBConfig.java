package com.example.user.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoDBConfig {
    @Autowired
    private MongoClient mongoClient;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(){
        ReactiveMongoTemplate template = new ReactiveMongoTemplate(mongoClient, dbName);
        MappingMongoConverter converter = (MappingMongoConverter) template.getConverter();
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        converter.afterPropertiesSet();
        return template;
    }
}
