package springcurso.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springcurso.curso.entities.OrderItem;
import springcurso.curso.entities.User;
import springcurso.curso.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
