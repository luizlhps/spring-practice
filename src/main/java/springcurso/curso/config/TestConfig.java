package springcurso.curso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import springcurso.curso.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
//    User u1 = new User(null, "maria", "maria@", "999999", "11111");
//    User u2 = new User(null, "mario", "mario@", "999999", "11111");
//
//    userRepository.saveAll(Arrays.asList(u1,u2 ));
    }
}
