package br.imd.ufrn.marketrest.services;

import br.imd.ufrn.marketrest.Repository.ProdutoRepository;
import br.imd.ufrn.marketrest.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto createProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> encontrarTodos(){
        return produtoRepository.findAll();
    }

    public List<Produto> produtosMenorPreco(List<Produto> produtos){
        return produtos;
    }

}
