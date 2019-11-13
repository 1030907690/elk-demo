package com.elk.example.elkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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

    /***
     * 第一个测试方法
     *   <pattern>%d{HH:mm:ss.SSS} %contextName [%thread] %-5level %logger{36} - %msg%n</pattern>
     * */
    @RequestMapping("/log")
    public String log( @RequestParam Map<String, String> params) {
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append(time);
        if (null != params) {
            params.forEach((k, v) -> {
                sb.append("#-#"+v);
            });
        }

        logger.info(sb.toString());
        return "ok";
    }
}
