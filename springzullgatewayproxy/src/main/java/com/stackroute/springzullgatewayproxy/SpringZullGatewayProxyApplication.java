package com.stackroute.springzullgatewayproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import com.stackroute.springzullgatewayproxy.filters.ErrorFilter;
import com.stackroute.springzullgatewayproxy.filters.PostFilter;
import com.stackroute.springzullgatewayproxy.filters.PreFilter;
import com.stackroute.springzullgatewayproxy.filters.RouteFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringZullGatewayProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZullGatewayProxyApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}