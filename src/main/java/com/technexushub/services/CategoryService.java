package com.technexushub.services;

import com.technexushub.dtos.CategoryDTO;
import com.technexushub.dtos.PageableResponse;

public interface CategoryService {
    CategoryDTO create(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO,String categoryId);
    void  delete(String categoryId);
    CategoryDTO getSingleDTO(String categoryId);
    PageableResponse<CategoryDTO>getAll(int pageNumber,int pageSize,String sortBy,String sortDir);
}
