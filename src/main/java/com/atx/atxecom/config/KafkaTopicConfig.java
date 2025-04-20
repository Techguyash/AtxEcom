package com.atx.atxecom.config;

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
    private String topicName;

    @Bean
    public NewTopic topic()
    {
        return TopicBuilder.name(topicName).build();
    }

}
