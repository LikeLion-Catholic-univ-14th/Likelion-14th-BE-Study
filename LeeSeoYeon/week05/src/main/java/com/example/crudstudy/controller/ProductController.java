package com.example.crudstudy.controller;

import com.example.crudstudy.dto.ProductDTO;
import com.example.crudstudy.entity.ProductEntity;
import com.example.crudstudy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //API와 View를 동시에 사용할 수 있다.
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 1. 상품 등록 폼
    @GetMapping("/new")
    public String newProductForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "product/new";
    }

    // 2. 상품 저장 처리
    @PostMapping("/create")
    public String createProduct(ProductDTO productDTO) {
        productService.create(productDTO);
        return "redirect:/products";
    }

    // 3. 상품 목록 조회 (주소: GET /products)
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    // 4. 상품 상세 조회 (주소: GET /products/{id})
    // @GetMapping 뒤에 "/{id}"를 추가하여 목록 조회와 주소를 구분해야 합니다.
    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/show";
    }

    // 5. 상품 수정 (주소: GET /products/{id}/edit)
    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable Long id, Model model) {
        ProductEntity product = productService.findById(id);
        //model.addAttribute("productDTO", productService.findById(id));
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable Long id, ProductDTO productDTO) {
        productService.update(id, productDTO);
        return "redirect:/products";
    }

    // 6. 상품 삭제 (주소: GET /product/{id}/delete)
    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}