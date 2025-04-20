package com.atx.postoffice.service;

import com.atx.postoffice.dto.NotifyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author ashiq
 * @createdOn 20/04/25 8:03 pm
 * @project AtxEcom
 **/
@Service
@Slf4j
public class SmsService implements MessageService
{

//    @KafkaListener(topics = "${spring.kafka.sms.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
@KafkaListener(topics = "sms-topic", groupId = "email-group")
    public void listen(NotifyDto dto) {
        log.info("Received SMS request: {}", dto);
        sendMessage(dto);
    }

    @Override
    public void sendMessage(NotifyDto notifyDto)
    {

    }
}
