package in.utrust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/**
 * @author RamPrasad
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class UtrustApplication {
	public static void main(String[] args) {
		SpringApplication.run(UtrustApplication.class, args);
	}

}
