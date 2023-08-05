package com.example.user.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "person")
@Data
public class ConfigProperties {

    private String name;
    private String lastName;

}
