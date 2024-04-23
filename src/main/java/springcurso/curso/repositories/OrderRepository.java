package springcurso.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springcurso.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
