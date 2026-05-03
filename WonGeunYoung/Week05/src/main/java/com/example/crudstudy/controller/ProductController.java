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

// @Controller: 사용자의 요청을 받는 클래스
@Controller

// 이 Controller의 기본 주소는 /products
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // 생성자 주입
    // Controller가 Service를 사용할 수 있게 연결
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create 1단계
    // 상품 등록 폼으로 이동
    // 주소: GET /products/new
    @GetMapping("/new")
    public String newProductForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        // templates/product/new.mustache 파일을 보여줌
        return "product/new";
    }

    // Create 2단계
    // 사용자가 입력한 데이터를 받아 DB에 저장
    // 주소: POST /products/create
    @PostMapping("/create")
    public String createProduct(ProductDTO productDTO) {
        productService.create(productDTO);
        // 저장 후 상품 목록 페이지로 이동
        return "redirect:/products";
    }

    // Read 1단계
    // 전체 상품 목록 조회
    // 주소: GET /products
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());

        // templates/product/list.mustache 파일을 보여줌
        return "product/list";
    }

    // Read 2단계
    // 특정 id를 가진 상품 상세 조회
    // 주소: GET /products/{id}
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));

        // templates/product/show.mustaches 파일을 보여줌
        return "product/show";
    }


    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        // 기존 데이터를 불러와서 모델에 담음
        Product product = productService.findById(id);
        model.addAttribute("product", product);

        return "product/edit";
    }

    @PostMapping("/update")
    public String updateProduct(ProductDTO productDTO) {
        productService.update(productDTO);

        return "redirect:/products/" + productDTO.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);

        // 삭제 후 목록 페이지로 이동
        return "redirect:/products";
    }
}