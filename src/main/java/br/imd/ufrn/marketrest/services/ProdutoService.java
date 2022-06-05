package br.imd.ufrn.marketrest.services;

import br.imd.ufrn.marketrest.Repository.ProdutoRepository;
import br.imd.ufrn.marketrest.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Produto> produtosMenorPreco(){
        List<Produto> produtosMercados= new ArrayList<>();
        List<Produto> produtosClientes = new ArrayList<>();

        for(Produto prod : produtoRepository.findAll()){
            if(prod.getPreco() == null){
                produtosClientes.add(prod);
            }else{
                produtosMercados.add(prod);
            }
        }

        List<String> produtosPorNome = new ArrayList<>();
        List<Produto> menoresPreco = new ArrayList<>();

        for(Produto prod : produtoRepository.findAll()){
            produtosPorNome.add(prod.getNome());
        }
        for(String nomeProduto: produtosPorNome){
            List<Produto> produtosFiltrados;
            List<String> filtroProduto = Arrays.asList(nomeProduto);

            produtosFiltrados = produtosMercados.stream()
                    .filter(produtoFiltrado-> filtroProduto.contains(produtoFiltrado.getNome()))
                    .collect(Collectors.toList());
            Produto menorPreco = produtosFiltrados.stream().min(Comparator.comparing(Produto::getPreco)).orElse(null);
            menoresPreco.add(menorPreco);
        }

        List<Produto> result = new ArrayList<>(new HashSet<>(menoresPreco));
        return result;
    }

}
