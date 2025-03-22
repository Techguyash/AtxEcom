package com.atx.atxecom.dto.appUsers;

import lombok.Data;

/**
 * @author ashiq
 * @createdOn 22/03/25 11:07 pm
 * @project AtxEcom
 **/
@Data
public class CreateUserResDTO
{
    String firstName;
    String lastName;
    String email;
    String otp;
    String password;
    String phoneNo;
}
