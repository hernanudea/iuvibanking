package com.iuvity;

import com.iuvity.hulkstore.product.infraestructure.service.KardexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IuvibankingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IuvibankingApplication.class, args);
	}
	@Autowired
	private KardexService kardexService;

	@Override
	public void run(String... args) throws Exception {

	}
}
