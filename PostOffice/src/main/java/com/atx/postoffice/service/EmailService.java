package com.atx.postoffice.service;

import com.atx.postoffice.dto.NotifyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author ashiq
 * @createdOn 20/04/25 8:00 pm
 * @project AtxEcom
 **/
@Service
@Slf4j
public class EmailService implements MessageService
{
    @KafkaListener(topics = "${spring.kafka.email.topic.name}", groupId = "postOffice")
    public void listen(NotifyDto dto) {
        log.info("Received NotifyDto: {}", dto.toString());
    }


    @Override
    public void sendMessage(NotifyDto notifyDto)
    {
        //send email
        log.info("Email sent", notifyDto);

    }


}
