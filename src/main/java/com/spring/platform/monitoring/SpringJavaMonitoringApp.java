package com.spring.platform.monitoring;

import io.prometheus.client.hotspot.DefaultExports;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import io.prometheus.client.spring.web.EnablePrometheusTiming;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@EnablePrometheusTiming
public class SpringJavaMonitoringApp {

	public static void main(String[] args) {
		DefaultExports.initialize();
		SpringApplication.run(SpringJavaMonitoringApp.class, args);
	}
}
