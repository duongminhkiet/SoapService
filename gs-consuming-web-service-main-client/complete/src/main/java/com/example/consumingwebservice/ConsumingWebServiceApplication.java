
package com.example.consumingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.consumingwebservice.wsdl.GetCountryResponse;

@SpringBootApplication
public class ConsumingWebServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner lookup(CountryClient quoteClient) {
//		return args -> {
//			String country = "Spain";
//
//			if (args.length > 0) {
//				country = args[0];
//			}
//			GetCountryResponse response = quoteClient.getCountry(country);
//			System.err.println(response.getCountry().getCurrency());
//		};
//	}

	@Autowired
	CountryClient quoteClient;
	@Override
	public void run(String... args) throws Exception {
		String country = "Spain";

		if (args.length > 0) {
			country = args[0];
		}
		if(quoteClient != null) {
			GetCountryResponse response = quoteClient.getCountry(country);
			if(response != null) {
				if(response.getCountry() != null) {
					System.out.println(response.getCountry().toString());
					System.err.println(response.getCountry().getCurrency());
				}else {
					System.out.println("response.getCountry() is null");
				}
				
			}else {
				System.out.println("response is null");
			}
		}
		
		
		
	}

}
