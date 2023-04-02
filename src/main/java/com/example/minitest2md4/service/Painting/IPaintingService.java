package com.example.minitest2md4.service.Painting;

import com.example.minitest2md4.model.Category;
import com.example.minitest2md4.model.Painting;
import com.example.minitest2md4.service.General.IGeneralService;

public interface IPaintingService extends IGeneralService<Painting> {

    Iterable<Painting> findAllByCategory(Category category);
}

