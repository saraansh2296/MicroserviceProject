package com.demoproject.productservice.Service;

import com.demoproject.productservice.Model.Product;
import com.demoproject.productservice.Model.ProductRequest;
import com.demoproject.productservice.Model.ProductResponse;
import com.demoproject.productservice.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(ProductRequest productRequest)
    {
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        log.info("Creating  Product : "+product);
        return  repository.save(product);
    }

    public java.util.Optional<Product> getProductById(String id)
    {
        return repository.findById(id);
    }


    public List<ProductResponse> getAllProducts(){
        List<Product> products = repository.findAll();
        
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return  ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public Product updateProduct(ProductRequest productRequest ){
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        log.info("updating  Product : "+product);
       return repository.save(product);
    }

    public void deleteProduct(String id ){
        log.info("Deleting  Product with Id : "+id);
         repository.deleteById(id);
    }



}
