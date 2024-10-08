package com.technexushub.controllers;

import com.codeneeti.technexushub.dtos.*;
import com.technexushub.dtos.CategoryDTO;
import com.technexushub.dtos.PageableResponse;
import com.technexushub.dtos.ProductDTO;
import com.technexushub.services.CategoryService;
import com.technexushub.services.ProductService;
import com.technexushub.dtos.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryServicee;
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> create(
            @RequestBody CategoryDTO categoryDTO
    ) {
        CategoryDTO categoryDTO1 = categoryServicee.create(categoryDTO);
        return new ResponseEntity<>(categoryDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryDTO> update(
            @PathVariable String categoryId,
            @RequestBody CategoryDTO categoryDTO
    ) {
        CategoryDTO updated = categoryServicee.update(categoryDTO, categoryId);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(
            @PathVariable String categoryId
    ) {
        categoryServicee.delete(categoryId);
        ApiResponse apiResponse = ApiResponse.builder()
                .message("Categorry is deleted")
                .success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<PageableResponse<CategoryDTO>> getAll(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        PageableResponse<CategoryDTO> allPageAbleResponse = categoryServicee.getAll(pageNumber, pageSize, sortBy, sortDir);
//        return new ResponseEntity<>(allPageAbleResponse, HttpStatus.OK);
        return ResponseEntity.ok(allPageAbleResponse);
        //we can send response in both wqy
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getSingle(
            @PathVariable("categoryId") String categoryId
    ) {
        CategoryDTO singleDTO = categoryServicee.getSingleDTO(categoryId);
        return ResponseEntity.ok(singleDTO);
    }

    //create product with category
    // @PathVariable("categoryId") String categoryId,
//  in bellow code this is  @PathVariable("categoryId") String categoryId, similar to  @PathVariable String categoryId,
    //because field name is same
    @PostMapping("/{categoryId}/products")
    public ResponseEntity<ProductDTO> createProductWithCategory(
            @PathVariable("categoryId") String categoryId,
            @RequestBody ProductDTO productDTO
    ) {
        ProductDTO productWithCategory = productService.createWithCategory(productDTO, categoryId);
        return new ResponseEntity<>(productWithCategory, HttpStatus.CREATED);
    }
    //update category of product
    @PutMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<ProductDTO>updateCategoryOfProduct(
            @PathVariable String categoryId,
            @PathVariable String  productId
    ){
        ProductDTO updateCategory = productService.updateCategory(productId, categoryId);
        return new ResponseEntity<>(updateCategory,HttpStatus.OK);
    }

//    getProduct of category
@GetMapping("/{categoryId}/products")
public ResponseEntity<PageableResponse<ProductDTO>> getProductOfCategory(
        @PathVariable String categoryId,
        @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
        @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
        @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir

){
    PageableResponse<ProductDTO> allOfCategory = productService.getAllOfCategory(categoryId,
            pageNumber,
            pageSize,
            sortBy,
            sortDir
    );

    return new ResponseEntity<>(allOfCategory,HttpStatus.OK);
}

}
