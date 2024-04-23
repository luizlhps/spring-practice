package springcurso.curso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import springcurso.curso.entities.Category;
import springcurso.curso.entities.Order;
import springcurso.curso.entities.Product;
import springcurso.curso.entities.User;
import springcurso.curso.entities.enums.OrderStatus;
import springcurso.curso.repositories.CategoryRepository;
import springcurso.curso.repositories.OrderRepository;
import springcurso.curso.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
    User u1 = new User(null, "maria", "maria@", "999999", "11111");
    User u2 = new User(null, "mario", "mario@", "999999", "11111");

    userRepository.saveAll(Arrays.asList(u1,u2 ));

    Order o1 = new Order(null, Instant.parse("2022-06-20T19:00:00Z"),u1, OrderStatus.CANCELED );
    Order o2 = new Order(null, Instant.parse("2022-06-20T19:00:00Z"),u1, OrderStatus.DELIVERED);

    orderRepository.saveAll(Arrays.asList(o1,o2 ));

    Category c1 = new Category(null, "Eltronic" );
    Category c2 = new Category(null, "lorem dhsd kalil " );

    categoryRepository.saveAll(Arrays.asList(c1,c2));

    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

    productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    p1.getCategories().add(c2);
    p2.getCategories().add(c1);
    p3.getCategories().add(c1);
    p4.getCategories().add(c2);
    p5.getCategories().add(c1);

    productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }
}
