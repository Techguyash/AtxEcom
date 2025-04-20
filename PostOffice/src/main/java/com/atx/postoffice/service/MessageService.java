package com.atx.postoffice.service;

import com.atx.postoffice.dto.NotifyDto;

/**
 * @author ashiq
 * @createdOn 20/04/25 7:53 pm
 * @project AtxEcom
 **/
public interface MessageService
{
    void sendMessage(NotifyDto notifyDto);
    void listen(NotifyDto dto);
}
