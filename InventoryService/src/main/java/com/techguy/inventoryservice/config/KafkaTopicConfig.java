package com.techguy.inventoryservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author ashiq
 * @createdOn 20/04/25 12:59 pm
 * @project AtxEcom
 **/
@Configuration
public class KafkaTopicConfig
{
    @Value("${spring.kafka.email.topic.name}")
    private String emailTopic;

    @Value("${spring.kafka.sms.topic.name}")
    private String smsTopic;

    @Bean
    public NewTopic emailTopic()
    {
        return TopicBuilder.name(emailTopic).build();
    }

    @Bean
    public NewTopic smsTopic()
    {
        return TopicBuilder.name(smsTopic).build();
    }

}
