package br.imd.ufrn.marketrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.imd.ufrn.marketrest.Repository.MarketRepository;
import br.imd.ufrn.marketrest.Repository.ProdutoRepository;
import br.imd.ufrn.marketrest.model.Market;
import br.imd.ufrn.marketrest.model.Produto;

@RestController
@RequestMapping("/markets")
public class MarketController {
    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Market> listMarkets(){
        return marketRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Market addMarket(@RequestBody Market market){
        return marketRepository.save(market);
    }

    @PostMapping(path = "/{id}/produtos")
    public Produto addProdutoInMarket(@RequestBody Produto produto, @PathVariable Long id){
        return produtoRepository.save(produto);
    }
}
