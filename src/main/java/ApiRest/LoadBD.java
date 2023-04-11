package ApiRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBD {

    private static final Logger log = LoggerFactory.getLogger(LoadBD.class);

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            log.info("Log of event save user 1:"
                    + repository.save(new Employee(null, "Israel", "Programador", "rua A numero 1")));
            log.info("Log of event save user 1:"
                    + repository.save(new Employee(null, "Douglas", "Gerente", "rua B numero 2")));
        };
    }
}
