package springcurso.curso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import springcurso.curso.entities.Category;
import springcurso.curso.entities.Order;
import springcurso.curso.entities.User;
import springcurso.curso.entities.enums.OrderStatus;
import springcurso.curso.repositories.CategoryRepository;
import springcurso.curso.repositories.OrderRepository;
import springcurso.curso.repositories.UserRepository;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
    User u1 = new User(null, "maria", "maria@", "999999", "11111");
    User u2 = new User(null, "mario", "mario@", "999999", "11111");

    userRepository.saveAll(Arrays.asList(u1,u2 ));

    Order o1 = new Order(null, Instant.parse("2022-06-20T19:00:00Z"),u1, OrderStatus.CANCELED );
    Order o2 = new Order(null, Instant.parse("2022-06-20T19:00:00Z"),u1, OrderStatus.DELIVERED);

    orderRepository.saveAll(Arrays.asList(o1,o2 ));

    Category c1 = new Category(null, "lorem dhsd kalil " );
    Category c2 = new Category(null, "lorem dhsd kalil " );

    categoryRepository.saveAll(Arrays.asList(c1,c2));
    }
}
