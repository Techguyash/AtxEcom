package com.atx.atxecom.controller;

import com.atx.atxecom.apiResponse.APIResponse;
import com.atx.atxecom.dto.notification.NotificationType;
import com.atx.atxecom.dto.notification.NotifyDto;
import com.atx.atxecom.services.kafka.PostMan;
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
    private PostMan postMan;

    @PostMapping("/email")
    public ResponseEntity<APIResponse> testEmailQueue()
    {
        NotifyDto dto=new NotifyDto("test@mail.com","This is a test mail from quue","Test mail from kafka queue","test status",
                NotificationType.EMAIL);
        postMan.sendEmail(dto);
        return ResponseEntity.ok(new APIResponse("Success"));
    }
    @PostMapping("/sms")
    public ResponseEntity<APIResponse> testSmSQueue()
    {
        NotifyDto dto=new NotifyDto
                ("test@mail.com",
                        "This is a test sms from quue","Test sms from kafka queue","test status",
                NotificationType.SMS);
        postMan.sendEmail(dto);
        return ResponseEntity.ok(new APIResponse("Success"));
    }
}
