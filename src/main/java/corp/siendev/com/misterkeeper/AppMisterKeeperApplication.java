package corp.siendev.com.misterkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class AppMisterKeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMisterKeeperApplication.class, args);
		SpringVersion.getVersion();
	}
}
