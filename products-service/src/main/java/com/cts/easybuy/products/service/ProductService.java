package com.cts.easybuy.products.service;

import com.cts.easybuy.products.dto.PagedResponse;
import com.cts.easybuy.products.dto.ProductDto;
import com.cts.easybuy.products.dto.ReviewDto;
import com.cts.easybuy.products.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface ProductService {


    //all products in paginated format
    PagedResponse<ProductDto> getAllProducts(int page, int size);

    //product dto by product id
    ProductDto getProductById(UUID productId);

    //product by category id in paginated way
    PagedResponse<ProductDto> getProductsByCategoryId(Long categoryId, int page, int size);

    //create new product
    ProductDto createProduct(ProductDto productDto);


    //update the product by product id
    ProductDto updateProduct(UUID productId, ProductDto productDto);

    //delete product by id
    void deleteProduct(UUID productId);

    //Add category to product --> product id, category id
    ProductDto addCategoryToProduct(UUID productId, Long categoryId);

    //Remove the category from product
    ProductDto removeCategoryFromProduct(UUID productId, Long categoryId);

    //Add Review to product--> product id ,
    ReviewDto addReviewToProduct(UUID productId, ReviewDto reviewDto);

    //Add product images
    ProductDto addProductImages(UUID productId, List<MultipartFile> files);

    //Get images of product
    List<String> getProductImages(UUID productId);
}
