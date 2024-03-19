package br.com.fiap.apiproduction.core.usecase.impl;

import br.com.fiap.apiproduction.core.Production;
import br.com.fiap.apiproduction.core.dataprovider.repository.ProductionRepository;
import br.com.fiap.apiproduction.core.usecase.ProductionUseCase;
import br.com.fiap.apiproduction.entrypoint.client.OrderClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionUseCaseImpl implements ProductionUseCase {

    @Autowired
    private OrderClient ordersClient;

    @Autowired
    private ProductionRepository repository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getAllOrders() {
        ResponseEntity<String> response = ordersClient.getAllOrders();

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                JsonNode rootNode = objectMapper.readTree(response.getBody());
                return rootNode;
            } catch (JsonProcessingException e) {
            }
        }

        return objectMapper.nullNode();
    }

    @Override
    public void createProduction(Production production) {
        repository.createProduction(production);
    }

    @Override
    public Production getProductionByProductionId(String productionId) {
        return repository.getProductionByProductionId(productionId);
    }

    @Override
    public List<Production> getAllProductions() {
        return repository.getAllProductions();
    }
}