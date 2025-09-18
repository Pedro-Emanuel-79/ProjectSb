package com.example.ProjectSb.controller;

import com.example.ProjectSb.entity.ProdutoEntity;
import com.example.ProjectSb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    //retorna lista de produtos
    @GetMapping("/produtos")
    public List<ProdutoEntity> getAllProducts() {
        List<ProdutoEntity> produtos = produtoService.getAllProductsService();
        return produtos;
    }

    @PostMapping("/cadastro")
    public ProdutoEntity cadastrarProduto(@RequestBody ProdutoEntity produto){
        return produtoService.save(produto);
    }

    @GetMapping("/produto/{id}")
    public ProdutoEntity getProduto(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }
}
