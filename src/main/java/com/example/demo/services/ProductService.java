package com.example.demo.services;

import com.example.demo.commands.ProductForm;
import com.example.demo.domain.Product;

public interface ProductService extends CRUDService<Product> {

    Product saveOrUpdate(ProductForm productForm);

}
