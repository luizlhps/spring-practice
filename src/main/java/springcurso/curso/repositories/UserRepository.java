package springcurso.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springcurso.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
