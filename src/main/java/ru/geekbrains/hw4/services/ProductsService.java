package ru.geekbrains.hw4.services;

import ru.geekbrains.hw4.entities.Product;
import ru.geekbrains.hw4.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProductById(int id) {
        return productsRepository.getProductById(id);
    }

    public List<Product> getProducts() {
        return productsRepository.getProducts();
    }

    public void addProduct(Product newProduct) {
        productsRepository.addProduct(newProduct);
    }

    public ProductsService() {

    }
}