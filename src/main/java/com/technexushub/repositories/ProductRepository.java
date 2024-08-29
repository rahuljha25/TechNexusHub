package com.technexushub.repositories;

import com.technexushub.entities.Category;
import com.technexushub.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {

    Page<Product> findByTitleContaining(String subTitle,Pageable pageable);
    Page<Product> findByLiveTrue(Pageable pageable);
    //other
    Page<Product>findByCategory(Category category,Pageable pageable);
}
