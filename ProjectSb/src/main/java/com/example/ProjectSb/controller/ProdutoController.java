package com.example.ProjectSb.controller;

import com.example.ProjectSb.entity.ProdutoEntity;
import com.example.ProjectSb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/produto/{id}")
    public ResponseEntity<Optional<ProdutoEntity>> getProductService(@PathVariable Long id){
        Optional<ProdutoEntity> produto = produtoService.getProductService(id);
        return ResponseEntity.ok(produto);//metodo pronto, já assume 200 OK.
    }

    @PostMapping("/produto/add")
    public ResponseEntity<ProdutoEntity> addProduct(@RequestBody ProdutoEntity produto){
        ProdutoEntity newProduct = produtoService.insertProductService(produto);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        //{
        //		"fornecedor" : "razer",
        //		"nome" : "Headset",
        //		"preco" : 560.90,
        //		"qtdEstoque" : 7
        //}
        // construtor, flexivel (você escolhe o status)
    }

    @PutMapping("/produto/update")
    public ResponseEntity<ProdutoEntity> updateProduct(@RequestBody ProdutoEntity produto){
        ProdutoEntity updatedProduct = produtoService.updateProductService(produto);
        return ResponseEntity.ok(updatedProduct); // metodo pronto, já assume 200 OK.
    }

    @DeleteMapping("/produto/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        produtoService.deleteProductByIdService(id);
        return ResponseEntity.noContent().build(); //retorna 204 no content, usa-se esse esse código de status para não precisar devolver um objeto no corpo da resposta, porque o recurso já foi removido.
    }
}
