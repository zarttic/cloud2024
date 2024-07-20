package org.zartt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zartt
 * @description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main9001
{
    public static void main(String[] args) {
        SpringApplication.run(Main9001.class,args);
    }
}