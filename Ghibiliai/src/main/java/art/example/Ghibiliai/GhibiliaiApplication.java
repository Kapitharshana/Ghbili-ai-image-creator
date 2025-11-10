package art.example.Ghibiliai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GhibiliaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhibiliaiApplication.class, args);
	}

}
