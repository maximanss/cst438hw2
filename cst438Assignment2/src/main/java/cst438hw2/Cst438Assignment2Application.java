package cst438hw2;

/**
 * This application is a web application which provide two kind of URL inputs
 * 1. Example: http://localhost:8080/cities/Miami
 *      It will return a html page about the Miami city's info that includes current temperature and time
 * 2. Example: http://localhost:8080/api/cities/Miami
 *      It will return a JSON format string of Miami's info instead
 *      
 * @author Max Halbert
 * @since 2021-05-09
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cst438Assignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cst438Assignment2Application.class, args);
	}

}
