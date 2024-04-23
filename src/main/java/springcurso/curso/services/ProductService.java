package springcurso.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcurso.curso.entities.Category;
import springcurso.curso.entities.Product;
import springcurso.curso.repositories.CategoryRepository;
import springcurso.curso.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }
    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.get();
    }

}
