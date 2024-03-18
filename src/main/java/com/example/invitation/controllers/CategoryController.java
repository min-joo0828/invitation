package com.example.invitation.controllers;

import com.example.invitation.models.Category;
import com.example.invitation.repositories.CategoryRepository;
import com.example.invitation.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<Category> getListCategory()
    {
        return service.getListCategory();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") long id) throws Throwable
    {
        return service.getCategory(id);
    }

    @GetMapping("/name/{name}")
    public List<Category> getCategoryByName(@PathVariable("name") String name)
    {
        return service.getCategoryByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long createCategory(@RequestBody Category category)
    {
        return service.createCategory(category);
    }

    @PutMapping("/{id}")
    public long updateCategory(@RequestBody Category category, @PathVariable("id") long id) throws Throwable
    {
        return service.updateCategory(category, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable("id") long id)
    {
        service.deleteCategory(id);
    }
}
