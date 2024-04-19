package springcurso.curso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springcurso.curso.entities.User;


@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(@RequestParam(value = "name", defaultValue = "World") String name) {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        return ResponseEntity.ok().body(u1);
    }
}
