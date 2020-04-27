package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController 
{
	private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String listProducts(Model model)
    {

        model.addAttribute("products", productService.listAllProducts());

        return "products";
    }
    
    @RequestMapping(value = "/product/{id}")
    public String getProductById(@PathVariable int id, Model model){

        model.addAttribute("product", productService.getProductById(id));

        return "product";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveProduct(Product product)
    {
        productService.saveOrUpdateProduct(product);
        return "redirect:/products/";
    }
    
    @RequestMapping(value = "/product/new/{id}")
    public String updateProduct(@PathVariable int id, Model model)
    {
    	Product updatedProduct = productService.getProductById(id);
    	model.addAttribute("product",updatedProduct);
    	return "productform";
    }
}
