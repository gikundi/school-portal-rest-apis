package co.ke.codemity.school.portalapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PortalApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApisApplication.class, args);
		System.out.println("Application started successfully *****************");
	}

}
