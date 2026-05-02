package com.example.crudstudy.controller;
import com.example.crudstudy.dto.ProductDTO;
import com.example.crudstudy.entity.Product;
import com.example.crudstudy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/new")
    public String newProductForm(Model model){
        model.addAttribute("productDto",new ProductDTO());
        return "product/new";
    }

    @PostMapping("/create")
    public String createProduct(ProductDTO productDTO){
        productService.create(productDTO);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable Long id, ProductDTO productDTO){
        productService.update(id, productDTO);
        return "redirect:/products";
    }

    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping
    public String listProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/show";
    }
}