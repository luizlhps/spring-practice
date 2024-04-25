package springcurso.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springcurso.curso.entities.User;
import springcurso.curso.repositories.UserRepository;
import springcurso.curso.services.exceptions.DatabaseException;
import springcurso.curso.services.exceptions.ResourceNotFound;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFound(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFound(id);
            }

         repository.deleteById(id);
        }  catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id,User data) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFound(id);
        }

        User userEntity = repository.getReferenceById(id);

        userEntity.setName(data.getName());
        userEntity.setEmail(data.getEmail());
        userEntity.setPassword(data.getPassword());
        userEntity.setPhone(data.getPhone());

        return repository.save(userEntity);
    }
}
