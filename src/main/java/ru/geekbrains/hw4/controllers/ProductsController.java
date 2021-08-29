package ru.geekbrains.hw4.controllers;

import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.hw4.entities.Product;
import ru.geekbrains.hw4.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/list")
    public String showProducts(Model uiModel) {
        uiModel.addAttribute("products", productsService.getProducts());
        return "products";
    }

    @RequestMapping("/product")
    public String showProduct(Model uiModel, @RequestParam("id") int id) {
        uiModel.addAttribute("product", productsService.getProductById(id));
        return "product";
    }

    @RequestMapping("/newProduct")
    public String showAddProductForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "newProductForm";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productsService.addProduct(product);
        return "newProductAdded";
    }
}
