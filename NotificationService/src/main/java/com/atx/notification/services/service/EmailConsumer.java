package com.atx.notification.services.service;

import com.atx.notification.services.dto.EmailNotificationDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author ashiq
 * @createdOn 20/04/25 1:35 pm
 * @project AtxEcom
 **/
@Service
@AllArgsConstructor
@Slf4j
public class EmailConsumer
{
    @KafkaListener(
            topics = "${spring.kafka.email.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeEmail(EmailNotificationDto dto){
        log.info("Consumed email notification : {}", dto);

    }
}
