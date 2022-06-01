package br.imd.ufrn.marketrest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

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

    @OneToMany(mappedBy = "market_id")
    private List<Produto> listProdutos;

    public void addProduto(Produto produto){
        this.listProdutos.add(produto);
    }
}
