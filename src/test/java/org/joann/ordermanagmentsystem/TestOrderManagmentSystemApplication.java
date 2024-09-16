package org.joann.ordermanagmentsystem;

import org.springframework.boot.SpringApplication;

public class TestOrderManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderManagmentSystemApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
