package com.hostmdy.property;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.hostmdy.property.bean.CloudDataSource;
import com.hostmdy.property.bean.Employee;
import com.hostmdy.property.bean.LombokTest;
import com.hostmdy.property.bean.MyDataSource;

import lombok.Lombok;

@SpringBootApplication
public class SpringPropertyTest1Application implements CommandLineRunner{

	@Autowired
	LombokTest lombokTest;
	
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringPropertyTest1Application.class, args);
		
		MyDataSource datasourceBean = context.getBean(MyDataSource.class);
		System.out.println("Username : "+datasourceBean.getUsername());
		System.out.println("Password : "+datasourceBean.getPassword());
		System.out.println("Url : "+datasourceBean.getUrl());
		
		CloudDataSource clouddataSource = context.getBean(CloudDataSource.class);
		System.out.println("Service : "+clouddataSource.getService());
		System.out.println("Authetication : "+clouddataSource.getAuthetication());
		System.out.println("Cached : "+clouddataSource.getCached());
	
		Employee employeeBean = context.getBean(Employee.class);
		System.out.println("FirstName : "+employeeBean.getFirstname());
		System.out.println("LastName : "+employeeBean.getLastname());
		System.out.println("Email : "+employeeBean.getEmail());
		System.out.println("Active : "+employeeBean.isActive());
		System.out.println("Fields : "+employeeBean.getFields());
//		List<String> fields = Arrays.asList(employeeBean.getFields());
//		fields.forEach(System.out::println);
		
//		for(String temp:employeeBean.getFields()) {
//			System.out.println(temp);
//		}
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(lombokTest);
		LombokTest testObj = new LombokTest(1001, "JawJaw", "9/balabala");
		System.out.println("Same Object ? "+lombokTest.equals(testObj));
	}

}
