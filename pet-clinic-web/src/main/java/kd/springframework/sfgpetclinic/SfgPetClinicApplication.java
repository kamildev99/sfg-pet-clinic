package kd.springframework.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"kd.springframework.sfgpetclinic"})
@SpringBootApplication
public class SfgPetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SfgPetClinicApplication.class, args);
	}

}
