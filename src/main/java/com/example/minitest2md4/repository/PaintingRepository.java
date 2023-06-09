package com.example.minitest2md4.repository;


import com.example.minitest2md4.model.Category;
import com.example.minitest2md4.model.Painting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends PagingAndSortingRepository<Painting, Long> {
    Iterable<Painting>findAllByCategory(Category category);
    Page<Painting> findAllByNamePainting(String name, Category category, Pageable pageable);
}
