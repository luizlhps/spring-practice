package springcurso.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcurso.curso.entities.Category;
import springcurso.curso.entities.Order;
import springcurso.curso.repositories.CategoryRepository;
import springcurso.curso.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    public List<Category> findAll() {
        return repository.findAll();
    }
    public Category findById(Long id) {
        Optional<Category> order = repository.findById(id);
        return order.get();
    }

}
