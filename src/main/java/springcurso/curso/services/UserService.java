package springcurso.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springcurso.curso.entities.User;
import springcurso.curso.repositories.UserRepository;

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
        return user.get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
     repository.deleteById(id);
    }

    public User update(Long id,User data) {
        User userEntity = repository.getReferenceById(id);

        userEntity.setName(data.getName());
        userEntity.setEmail(data.getEmail());
        userEntity.setPassword(data.getPassword());
        userEntity.setPhone(data.getPhone());

        return repository.save(userEntity);
    }
}
