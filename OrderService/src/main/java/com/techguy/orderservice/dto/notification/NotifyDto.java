package com.techguy.orderservice.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ashiq
 * @createdOn 20/04/25 7:57 pm
 * @project AtxEcom
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotifyDto
{
    private String to;
    private String subject;
    private String body;
    private String status;
    private NotificationType notifyType; // sms or mail
}
