package com.spring.platform.monitoring.controller;

import io.prometheus.client.spring.web.PrometheusTimeMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    @PrometheusTimeMethod(name = "hello_controller_say_hello_duration_seconds", help = "Some helpful info here")
    public String sayHello() {
        return "hello";
    }
}
