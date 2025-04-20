package com.atx.postoffice.dto;

import lombok.*;

/**
 * @author ashiq
 * @createdOn 20/04/25 7:57 pm
 * @project AtxEcom
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NotifyDto
{
    private String to;
    private String subject;
    private String body;
    private String status;
    private String notifyType; // sms or mail
}
