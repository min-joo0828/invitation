package com.example.invitation.repositories;

import com.example.invitation.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name);

    List<Category> findByNameOrPrefix(String name, String prefix);

}
