package com.eduardoguedes.trackhours;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Track Hours", version = "1", description = "System of control de employees"))
@SpringBootApplication
public class TrackhoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackhoursApplication.class, args);
	}

}
