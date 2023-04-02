package com.example.minitest2md4.repository;


import com.example.minitest2md4.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {

}
