package br.com.alura.dojoadopt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class DojoAdoptApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojoAdoptApplication.class, args);
	}

	@GetMapping("/")
	public String ola() {
		return "oi";
	}
}
