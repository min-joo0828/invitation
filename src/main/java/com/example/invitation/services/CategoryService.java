package com.example.invitation.services;

import com.example.invitation.models.Category;
import com.example.invitation.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository)
    {
        this.repository = repository;
    }

    public long createCategory(Category category)
    {
        return repository.save(category).getId();
    }

    public long updateCategory(Category category, long id) throws Throwable
    {
        return repository.save(category.toEntity(getCategory(id))).getId();
    }

    public void deleteCategory(long id)
    {
        repository.deleteById(id);
    }

    public Category getCategory(long id) throws Throwable
    {
        return repository.findById(id).orElseThrow(
            (Supplier<Throwable>) () -> new RuntimeException("원하는 상품이 없습니다."));
    }

    public List<Category> getListCategory()
    {
        return repository.findAll();
    }

    public List<Category> getCategoryByName(String name)
    {
        return repository.findByName(name);
    }
}
