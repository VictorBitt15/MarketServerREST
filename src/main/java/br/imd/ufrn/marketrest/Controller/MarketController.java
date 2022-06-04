package br.imd.ufrn.marketrest.Controller;

import java.util.List;

import br.imd.ufrn.marketrest.services.MarketService;
import br.imd.ufrn.marketrest.services.ProdutoService;
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
    private MarketService marketService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Market> listMarkets(){
        return marketService.listarMercados();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Market addMarket(@RequestBody Market market){
        return marketService.createMercado(market);
    }

    @PostMapping(path = "/{nome}")
    public Produto addProdutoInMarket(@RequestBody Produto produto, @PathVariable String nome){
        return marketService.addProduto(nome,produto);
    }
}
