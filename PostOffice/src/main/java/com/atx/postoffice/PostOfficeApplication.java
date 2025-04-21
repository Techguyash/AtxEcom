package com.atx.postoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PostOfficeApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(PostOfficeApplication.class, args);
    }

}
