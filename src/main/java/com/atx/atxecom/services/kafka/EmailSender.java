package com.atx.atxecom.services.kafka;

import com.atx.atxecom.dto.EmailNotificationDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author ashiq
 * @createdOn 20/04/25 1:03 pm
 * @project AtxEcom
 **/
@Service
@AllArgsConstructor
@Slf4j
public class EmailSender
{

    private NewTopic emailTopic;
    private KafkaTemplate<String, EmailNotificationDto> kafkaTemplate;

    public void sendEmail(EmailNotificationDto event)
    {
      log.info("Sending message to email topic : {}", event.toString());
      //create Message
        Message<EmailNotificationDto> message= MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,emailTopic.name())
                .build();

        kafkaTemplate.send(message);


    }
}
