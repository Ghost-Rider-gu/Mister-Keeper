package corp.siendev.com.keeper.musicservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {
    @Value("${example.property}")
    private String name;

    public String getName() {
        return name;
    }
}
