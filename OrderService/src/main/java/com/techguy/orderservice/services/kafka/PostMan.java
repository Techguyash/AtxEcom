package com.techguy.orderservice.services.kafka;


import com.techguy.orderservice.dto.notification.NotificationType;
import com.techguy.orderservice.dto.notification.NotifyDto;
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
public class PostMan
{

    private NewTopic emailTopic;
    private NewTopic smsTopic;
    private KafkaTemplate<String, NotifyDto> kafkaTemplate;

    public void sendEmail(NotifyDto event)
    {
        Message<NotifyDto> message = null;
        if(event.getNotifyType()== NotificationType.EMAIL)
        {
            log.info("Sending message to email topic : {}", event.toString());
            //create Message
            message = MessageBuilder
                    .withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC, emailTopic.name())
                    .build();

        }
        else if(event.getNotifyType()== NotificationType.SMS)
        {
            log.info("Sending message to sms topic : {}", event.toString());
            message = MessageBuilder.withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC,smsTopic.name())
                    .build();
        }



        kafkaTemplate.send(message);

    }
}
