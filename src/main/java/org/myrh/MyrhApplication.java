package org.myrh;

import javax.annotation.Resource;

import org.myrh.entities.FileStorageProperties;
import org.myrh.entities.HTMLMail;
import org.myrh.entities.SimpleMail;
import org.myrh.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableConfigurationProperties({
	
	 FileStorageProperties.class
})
//@EnableJpaRepositories("org.myrh.HibernateConfiguration.class")
//@ComponentScan({"org.myrh.dao"})
public class MyrhApplication {   
	
	public static void main(String[] args) {
		SpringApplication.run(MyrhApplication.class, args);
	}
	
 

}
  