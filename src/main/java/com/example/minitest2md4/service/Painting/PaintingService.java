package com.example.minitest2md4.service.Painting;


import com.example.minitest2md4.model.Category;
import com.example.minitest2md4.model.Painting;
import com.example.minitest2md4.repository.CategoryRepository;
import com.example.minitest2md4.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PaintingService implements IPaintingService{
    @Autowired
   private PaintingRepository paintingRepository;
    @Override
    public Iterable<Painting> findAll() {
        return paintingRepository.findAll();
    }

    @Override
    public Optional<Painting> findById(Long id) {
        return paintingRepository.findById(id);
    }

    @Override
    public void save(Painting painting) {
        paintingRepository.save(painting);
    }

    @Override
    public void remove(Long id) {
paintingRepository.deleteById(id);
    }


    @Override
    public Iterable<Painting> findAllByCategory(Category category) {
        return paintingRepository.findAllByCategory(category);
    }
}
