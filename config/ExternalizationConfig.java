package com.Springlog4j.config;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ExternalizationConfig {

	File propertyFile;
	private static String accode ="";
	
	public void OsCheck() {
		
		String command = "";
		String osName=System.getProperty("os.name");
		if(osName.startsWith("Windows")) {
			System.out.println("Windows OS");
			propertyFile = new File("E:\\log\\config.properties");}
		else {
			if(osName.startsWith("Mac")|| osName.startsWith("HP-UX")||osName.startsWith("Linux"))
			{
				System.out.println("Linux OS");
				
				File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
				propertyFile = new File(catalinaBase,"bin/demo-config");}
			   else {
					System.out.println("The current operating system "+ osName+ "is not supported");		
				}

			}
		}
	
//	@Value("${spring.datasource.driver}")
//	private String driver;
//	@Value("${spring.datasource.password}")
//	private String passWord;
//	@Value("${spring.datasource.url}")
//	private String url;
//	@Value("${hibernate.dialect}")
//	private String dialect;
//	@Value("${hibernate.show.sql}")
//	private String show_sql;
//	@Value("${spring.datasource.username}")
//	private String userName;
	
//	@Bean
//	public DataSource dataSource() {
//		OsCheck();
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		try {
//			InputStream in = new FileInputStream(propertyFile);
//			ResourceBundle resourceBundle = new PropertyResourceBundle(in);
//			dataSource.setDriverClassName(resourceBundle.getString(driver));
//			dataSource.setUrl(resourceBundle.getString(url));
//			dataSource.setUsername(resourceBundle.getString(userName));
//			dataSource.setPassword(resourceBundle.getString(passWord));		
//		}
//		catch(Exception e) {
//			
//			e.printStackTrace();
//			
//		}
//		return  dataSource;
//		
//	}
//	@Bean(name="entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactoty() {
//	
//		LocalSessionFactoryBean sessionFactory =new  LocalSessionFactoryBean();
//		sessionFactory .setDataSource(dataSource());
//		 sessionFactory.setPackagesToScan("com");
//		 Properties hibernateproperty = new Properties();
//		 hibernateproperty.put("hibernate.show.sql",show_sql);
//		// hibernateproperty.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO)
//		 sessionFactory.setHibernateProperties(hibernateproperty);
//		return sessionFactory;
//		
//	}
//	@Bean
//	public HibernateTransactionManager transactionManager() {
//		
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(sessionFactoty().getObject());
//		return transactionManager;
//	
//	}
		
	}
