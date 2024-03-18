package com.example.invitation.controllers;

import com.example.invitation.models.Category;
import com.example.invitation.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

//    @Autowired
    CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Category> getListCategory()
    {
        return repository.findAll();
//        return repository.findByName("ming");
    }

    @PostMapping
    public long createCategory(
            @RequestBody Category category
    )
    {
        return repository.save(category).getId();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(
            @PathVariable("id") long id
    )
    {
        repository.deleteById(id);
    }
}
