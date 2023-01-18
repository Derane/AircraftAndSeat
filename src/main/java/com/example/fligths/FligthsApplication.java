package com.example.fligths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.jdbc.Sql;

@SpringBootApplication
@Sql({
		"classpath:sql/data.sql"
})
public class FligthsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FligthsApplication.class, args);
	}

}
