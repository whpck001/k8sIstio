/**
 *
 */
package com.gear.istio.product.config;

import com.gear.istio.product.config.interceptor.FeignBasicAuthRequestInterceptor;
import feign.Feign;
import feign.Logger;
import feign.Request.Options;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;


@Configuration
@ConditionalOnClass({ Feign.class })
public class FeignConfiguration {

	@Autowired
	Environment environment;


	@Bean
	public Retryer retryer() {
		return new Retryer.Default(0, 0, 0);
	}

	@Bean
	public Options options(){
		return new Options(60 * 1000, 60 * 1000);
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Primary
	@Bean
	RestTemplate azRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	// 创建Feign请求拦截器
	@Bean
	public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new FeignBasicAuthRequestInterceptor();
	}

}
