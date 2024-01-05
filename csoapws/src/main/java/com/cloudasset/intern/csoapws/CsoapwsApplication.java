package com.cloudasset.intern.csoapws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

	@SpringBootApplication
public class CsoapwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsoapwsApplication.class, args);
	}
	@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String country = null;
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter Country name: ");
			country=scanner.next();
			scanner.close();
			if (args.length > 0) {
				country = args[0];
			}
			try {
				GetCountryResponse response = countryClient.getCountry(country);
				System.err.println(response.getCountry().getCapital());
				System.err.println(response.getCountry().getCurrency());
				System.err.println(response.getCountry().getPopulation());
			}catch (NullPointerException e){
				System.out.println(e.getMessage());
			}
		};
	}
}
