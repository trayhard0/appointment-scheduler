package io.github.trayhard0.appointmentscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@SpringBootApplication
public class AppointmentSchedulerApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppointmentSchedulerApplication.class, args);
	}
}
