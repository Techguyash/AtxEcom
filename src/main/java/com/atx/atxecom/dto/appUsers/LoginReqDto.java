package com.atx.atxecom.dto.appUsers;

import lombok.Data;

/**
 * @author ashiq
 * @createdOn 23/03/25 4:49 am
 * @project AtxEcom
 **/
@Data
public class LoginReqDto
{
    private String email;
    private String password;

}
