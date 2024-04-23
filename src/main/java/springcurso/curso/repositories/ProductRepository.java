package springcurso.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springcurso.curso.entities.Category;
import springcurso.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
