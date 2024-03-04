package com.example.insurancemicroservice.repository;

import com.example.insurancemicroservice.domain.Category;
import com.example.insurancemicroservice.domain.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    public Category getCategoryByCategoryType(CategoryType categoryType);
}
