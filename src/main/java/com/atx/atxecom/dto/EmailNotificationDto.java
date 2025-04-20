package com.atx.atxecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ashiq
 * @createdOn 20/04/25 12:44 pm
 * @project AtxEcom
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailNotificationDto
{
    private String email;
    private String subject;
    private String body;
    private String status;


}
