package com.Springlog4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({"E:\\log\\config.properties"})
//@ContextConfiguration(locations={"E:\\log\\config.properties"})
//@PropertySource("E:\\log\\config.properties")
public class SpringLog4jApplication implements CommandLineRunner {

//	@Value("${config.properties}")
//	private String a;
	@Autowired
	private Environment environment;
	private static Logger log = LogManager.getLogger(SpringLog4jApplication.class.getName());

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(SpringLog4jApplication.class, args);
//		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SpringBootConfiguration.class)
//				.properties("E:\\log\\config.properties")
//				.build().run(args);
//		ConfigurableEnvironment environment = applicationContext.getEnvironment();
//		System.out.println(environment.getProperty("config.properties"));

//		FileReader fr=new FileReader("E:\\log\\config.properties");
//		
//		ConfigurableEnvironment env = fr.getEnvironment();

	}
//	@Autowired
//	private Environment environment;

	@Override
	public void run(String... args) throws Exception {

		log.info("Log4j INFO Application Started.....!!!!");
		log.trace("Log4j TRACE Application Started.....!!!!");
		log.debug("Log4j DEBUG Application Started.....!!!!");
		log.error("Log4j ERROR Application Started.....!!!!");
		log.fatal("Log4j FATAL Application Started.....!!!!");

		 log.info("-------------------- test data : " +getProperty().getProperty("spring.message"));
		// environment.getProperty("config.properties"));
	}

//	@Bean
//	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//	    PropertySourcesPlaceholderConfigurer properties = 
//	      new PropertySourcesPlaceholderConfigurer();
//	    properties.setLocation(new FileSystemResource("E:\\log\\config.properties"));
//	    properties.setIgnoreResourceNotFound(false);
//	    return properties;
//	}
	
	
	@Bean
	public Properties getProperty() throws IOException {
		InputStream iStream = new FileInputStream(new File("E:\\log\\config.properties"));
		Properties properties = new Properties();
		properties.load(iStream);
		return properties;

	}
}
