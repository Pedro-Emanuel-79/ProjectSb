package com.example.ProjectSb.service;

import com.example.ProjectSb.entity.ProdutoEntity;
import com.example.ProjectSb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> getAllProductsService() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtos;
    }

    public Optional<ProdutoEntity> getProductService(Long id){
        return produtoRepository.findById(id);
    }

    public ProdutoEntity insertProductService(ProdutoEntity produto){
        return produtoRepository.save(produto);
    }

    public void deleteProductByIdService(Long id){
        produtoRepository.deleteById(id);
    }

    public ProdutoEntity updateProductService(ProdutoEntity produto){
        ProdutoEntity updateProduct = produtoRepository.findById(produto.getId()).get();
        updateProduct = produto;
        return produtoRepository.save(updateProduct);
    }
}
