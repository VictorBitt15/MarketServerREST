package br.imd.ufrn.marketrest.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private Double preco; 

    @Column(nullable = true)
    private Long market_id;

}
