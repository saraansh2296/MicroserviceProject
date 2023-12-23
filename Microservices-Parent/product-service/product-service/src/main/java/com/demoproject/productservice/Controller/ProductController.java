package com.demoproject.productservice.Controller;

import com.demoproject.productservice.Model.Product;
import com.demoproject.productservice.Model.ProductRequest;
import com.demoproject.productservice.Model.ProductResponse;
import com.demoproject.productservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/saveProducts")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody ProductRequest product){
        return service.createProduct(product);

    }

    @GetMapping("/getAllProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return service.getAllProducts();

    }







}
