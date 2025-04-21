package com.techguy.orderservice.dto.appUsers;

import lombok.Data;

/**
 * @author ashiq
 * @createdOn 22/03/25 11:07 pm
 * @project AtxEcom
 **/
@Data
public class CreateUserReqDTO
{
    String firstName;
    String lastName;
    String email;
    String password;
    String phoneNo;
}
