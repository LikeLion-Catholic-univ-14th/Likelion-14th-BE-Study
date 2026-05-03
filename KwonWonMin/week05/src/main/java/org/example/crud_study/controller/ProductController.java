package org.example.crud_study.controller;

import org.example.crud_study.entity.Product;
import org.springframework.ui.Model;
import org.example.crud_study.dto.ProductDTO;
import org.example.crud_study.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //Create 1단계 - 상품 등록 폼으로 이동
    @GetMapping("/new")
    public String newProductForm(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        return "product/new";
    }

    //Create 2단계 - 사용자가 입력한 데이터를 받아 DB에 저장
    @PostMapping("/create")
    public String createProduct(ProductDTO productDTO){
        productService.create(productDTO);
        //저장 후 상품 목록 페이지로 이동
        return "redirect:/products";
    }

    //Read 1단계 - 전체 상품 목록 조회
    @GetMapping
    public String listProducts(Model model){
        model.addAttribute("products", productService.findAll());
        //templates/product/list.mustache 파일을 보여줌
        return "product/list";
    }

    //Read 2단계 - 특정 id를 가진 상품 상세 조회
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/show";
    }

    //Update 1단계 - 수정 폼으로 이동
    @GetMapping("/{id}/edit")
    public String editFrom(@PathVariable Long id, Model model){
        Product product = productService.findById(id);
        ProductDTO dto = new ProductDTO(product.getId(),product.getProductName(), product.getPrice());
        model.addAttribute("productDTO", dto);
        return "product/edit";
    }
    //Update 2단계 - 수정 처리
    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable Long id, ProductDTO productdto){
        productService.update(id,productdto);
        return "redirect:/products";
    }

    //Delete
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/products";
    }


}
