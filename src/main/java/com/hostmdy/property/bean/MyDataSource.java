package com.hostmdy.property.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

//@Getter
//@Setter
//@AllArgsConstructor
//@EnableConfigurationProperties
//@ConfigurationProperties(prefix = "oracle")
@Value // Immutable Class -> DTO
public class MyDataSource {
	
	private String username;
	private String password;
	private String url;

}
