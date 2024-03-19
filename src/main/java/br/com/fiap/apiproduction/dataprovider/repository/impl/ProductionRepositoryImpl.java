package br.com.fiap.apiproduction.dataprovider.repository.impl;

import br.com.fiap.apiproduction.core.Production;
import br.com.fiap.apiproduction.core.dataprovider.repository.ProductionRepository;
import br.com.fiap.apiproduction.dataprovider.repository.ProductionRepositoryJpa;
import br.com.fiap.apiproduction.dataprovider.repository.entity.ProductionEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductionRepositoryImpl implements ProductionRepository {

    private final ProductionRepositoryJpa productionRepository;

    public ProductionRepositoryImpl(ProductionRepositoryJpa productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public void createProduction(Production production) {
        productionRepository.save(new ProductionEntity(production));
    }

    @Override
    public Production getProductionByProductionId(String productionId) {
        return productionRepository.findById(productionId).get().toProduction();
    }

    @Override
    public List<Production> getAllProductions() {
        List<ProductionEntity> entities = this.productionRepository.findAll();
        return entities.stream().map(ProductionEntity::toProduction).toList();
    }
}
