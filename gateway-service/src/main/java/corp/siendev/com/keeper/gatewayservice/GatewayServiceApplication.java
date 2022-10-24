/*
 * Copyright (c) 2022
 * Ghost Rider aka Iurii Golubnichenko
 */

package corp.siendev.com.keeper.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceApplication {
    public static void main( String[] args ) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
