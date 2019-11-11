package com.elk.example.elkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ElkDemoApplication {

	private final Logger logger = LoggerFactory.getLogger(ElkDemoApplication.class);
	public static void main(String[] args) {
	 new SpringApplicationBuilder(ElkDemoApplication.class)
		 .bannerMode(Banner.Mode.OFF)
		 .web(WebApplicationType.SERVLET)
		 .run(args);
	}

	@RequestMapping("/log")
	public String log(String text){
		logger.info(text);
		return "ok";
	}
}
