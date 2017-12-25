package com.znsd.SpringBootBegin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



//开启eureka服务
@EnableEurekaServer
//springBoot注解,spring在springBoot基础之上来构建项目
@SpringBootApplication
public class App 
{
  public static void main( String[] args )
  { 
      new SpringApplicationBuilder(App.class).web(true).run(args);
  }
}
