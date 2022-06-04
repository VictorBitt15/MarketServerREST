package br.imd.ufrn.marketrest.services;

import br.imd.ufrn.marketrest.Repository.MarketRepository;
import br.imd.ufrn.marketrest.Repository.ProdutoRepository;
import br.imd.ufrn.marketrest.model.Market;
import br.imd.ufrn.marketrest.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;


import java.util.List;

@Service
public class MarketService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private MarketRepository marketRepository;

    public List<Market> listarMercados(){
        return marketRepository.findAll();
    }

    public Market createMercado(Market mercado){
        return marketRepository.save(mercado);
    }

    public Produto addProduto(String nome, Produto produto){
        Market market = marketRepository.findByNome(nome);
        market.addProdutos(produto);

        return produtoRepository.save(produto);
    }
}
