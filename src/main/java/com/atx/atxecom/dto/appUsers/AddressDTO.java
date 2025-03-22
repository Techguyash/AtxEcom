package com.atx.atxecom.dto.appUsers;

import java.io.Serializable; /**
     * DTO for {@link com.atx.atxecom.entity.Address}
     */
    public class AddressDTO
            implements Serializable
    {
        long AddressId; String addressLine1;
        String addressLine2; 
        String city;
        String state;
        String country; String postalCode;
    }
