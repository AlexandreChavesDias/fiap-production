package br.com.fiap.apiproduction.core.dataprovider.repository;

import br.com.fiap.apiproduction.core.Production;

import java.util.List;

public interface ProductionRepository {

    void createProduction(Production production);

    Production getProductionByProductionId(String productionId);

    List<Production> getAllProductions();

}
