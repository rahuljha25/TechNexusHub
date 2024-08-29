package com.technexushub.services;

import com.technexushub.dtos.PageableResponse;
import com.technexushub.dtos.ProductDTO;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO, String productId);

    void delete(String productId);

    ProductDTO get(String productId);

    PageableResponse<ProductDTO> getAll(int pageNumber,
                                        int pageSize,
                                        String sortBy,
                                        String sortDir);

    PageableResponse<ProductDTO> getAllLive(int pageNumber,
                                            int pageSize,
                                            String sortBy,
                                            String sortDir);

    PageableResponse<ProductDTO> searchByTitle(String pageNumber,
                                               int numberSize,
                                               int pageSize,
                                               String sortBy,
                                               String sortDir);
    //create product with Category
    ProductDTO createWithCategory(ProductDTO productDTO,String categoryId);
    ProductDTO updateCategory(String productId,String categoryId);

    PageableResponse<ProductDTO>getAllOfCategory(String categoryId,int pageNumber,
                                                int pageSize,
                                                String sortBy,
                                                String sortDir);

}
