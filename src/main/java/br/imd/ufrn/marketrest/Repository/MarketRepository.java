package br.imd.ufrn.marketrest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.ufrn.marketrest.model.Market;

public interface MarketRepository extends JpaRepository<Market, Long>{
    
}
