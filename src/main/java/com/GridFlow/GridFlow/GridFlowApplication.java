package com.GridFlow.GridFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.GridFlow.GridFlow")
public class GridFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(GridFlowApplication.class, args);
	}

}
