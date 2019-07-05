package com.example.demo;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.example.demo.mapper")
public class SpringbootdemoApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootdemoApplication.class, args);
//		SpringContextUtil.setApplicationContext(applicationContext);
		System.out.println("启动成功！");
	}

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootdemoApplication.class);
	}

	
   @Autowired
   private ApplicationContext appContext;

	
	@Override
	public void run(String... args) throws Exception {
		
		String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans)
        {
            System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
        }

	}

}
