package com.example.test.mongockpoc;

//import com.github.cloudyrock.spring.v5.EnableMongock;
import io.mongock.api.annotations.MongockCliConfiguration;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableMongock
//@MongockCliConfiguration(sources = RunnerBuilderProviderImpl.class)
@EnableMongock
public class MongockpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongockpocApplication.class, args);
	}

}
