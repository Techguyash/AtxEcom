package com.atx.atxecom.controller;

import com.atx.atxecom.apiResponse.APIResponse;
import com.atx.atxecom.dto.EmailNotificationDto;
import com.atx.atxecom.services.kafka.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashiq
 * @createdOn 20/04/25 1:11 pm
 * @project AtxEcom
 **/
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController
{
    private EmailSender emailSender;

    @PostMapping("/email")
    public ResponseEntity<APIResponse> testEmailQueue()
    {
        EmailNotificationDto dto=new EmailNotificationDto("test@mail.com","This is a test mail from quue","Test amil from kafka queue","test status");
        emailSender.sendEmail(dto);
        return ResponseEntity.ok(new APIResponse("Success"));
    }
}
