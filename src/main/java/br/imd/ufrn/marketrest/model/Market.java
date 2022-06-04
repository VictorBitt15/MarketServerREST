package br.imd.ufrn.marketrest.model;

import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Market {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String nome;

    @OneToMany
    private List<Produto> produtos;

    public void setProdutos(){
        if(this.produtos == null){
            this.produtos = new ArrayList<>();
        }
    }
    public void addProdutos(Produto produto){
        this.produtos.add(produto);
    }
   
}
