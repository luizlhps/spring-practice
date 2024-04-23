package springcurso.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springcurso.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
