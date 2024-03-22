package com.abstractionizer.Hello.World;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

@Slf4j
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableEnvironment env = SpringApplication.run(HelloWorldApplication.class, args).getEnvironment();

		String protocol = "http";
		if(Objects.nonNull(env.getProperty("server.ssl.key-store"))){
			protocol = "https";
		}
		log.info("\n------------------------------------------------------------\n\t" +
				"Application '{}' is running! Access URLs:\n\t" +
				"Local {}://localhost:{}\n\t" +
				"External {}://{}:{}\n\t" +
				"Profile(s): {}\n" +
				"------------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol, env.getProperty("server.port"),
				protocol, InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"),
				env.getProperty("spring.profiles.active"));
	}

}
