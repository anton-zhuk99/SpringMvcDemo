package com.example.mvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

@SpringBootApplication // @Configuration, @ComponentScan
public class SpringMvcDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDemoProjectApplication.class, args);
	}

	@Bean
	public Random randomBean() {
		return new Random(System.currentTimeMillis());
	}

	@Bean
	public Random randomBeanWithSeed() {
		return new Random(123456789L);
	}

	@Bean
	public Connection connection() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pass = "admin";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
