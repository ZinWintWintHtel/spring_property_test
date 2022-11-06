package com.hostmdy.property.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.hostmdy.property.bean.CloudDataSource;
import com.hostmdy.property.bean.LombokTest;
import com.hostmdy.property.bean.MyDataSource;

import lombok.Lombok;

@Configuration
//@PropertySource({"classpath:oracle.datasource.properties","classpath:aws_cloud.datasource.properties"})
/*
 * @PropertySources({
 * 
 * @PropertySource("classpath:oracle.datasource.properties"),
 * 
 * @PropertySource("classpath:aws_cloud.datasource.properties"), })
 */

public class DataSourceConfig {
	
	@Autowired
	Environment env;

	@Value("${oracle.username}")
	String username;
	
	@Value("${oracle.password}")
	String password;
	
	@Value("${oracle.url}")
	String url;
	
	@Value("${aws.cloud.service}")
	public String service;
	
	@Value("${aws.cloud.authetication}")
	public String authetication;
	
	@Value("${aws.cloud.cached}")
	public String cached;
	
	@Bean
	LombokTest lombokTest() {
		return new LombokTest(1001, "JawJaw", "9/balabala");
	}
	
	@Bean
	MyDataSource myDataSource() {
		return new MyDataSource(env.getProperty("username"),env.getProperty("password"), url);
	}
	
	@Bean
	CloudDataSource cloudDataSource() {
		return new CloudDataSource(service, authetication, cached);
	}
	
	@Bean
	static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
}
