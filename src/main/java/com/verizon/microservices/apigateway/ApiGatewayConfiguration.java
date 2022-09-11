
package com.verizon.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	/*@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

		Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "sso_jwt").addRequestParameter("myrequest", "Data"))
				.uri("http://httpbin.org:80");
		return builder.routes().route(routeFunction).build();
	} */
	
	//Simple routelocator
	/*@Bean
	public RouteLocator routeGateWay(RouteLocatorBuilder build) {
		
		Function<PredicateSpec, Buildable<Route>> routePath = p -> p.path("/get")
				.uri("http://httpbin.org:80");
		
		return build.routes().route(routePath).build();
	} */
	
	//route locator to add coustome header and request body
	
	@Bean
	public RouteLocator gateWayRouter(RouteLocatorBuilder builder) {
		
	return	builder.routes().route(p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "MyUri")
						.addRequestParameter("Param", "MyValue"))
				.uri("http://httpbin.org:80")).build();
	}
}
