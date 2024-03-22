package br.com.fiap.apiproduction.core.usecase;

import br.com.fiap.apiproduction.core.Production;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface ProductionUseCase {

    JsonNode getAllOrders();

    void createProduction(Production production);

    Production getProductionByProductionId(String productionId);

    List<Production> getAllProductions();
}
