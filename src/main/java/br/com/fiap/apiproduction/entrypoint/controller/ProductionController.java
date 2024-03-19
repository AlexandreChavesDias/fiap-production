package br.com.fiap.apiproduction.entrypoint.controller;

import br.com.fiap.apiproduction.core.usecase.ProductionUseCase;
import br.com.fiap.apiproduction.entrypoint.dto.request.ProductionRequest;
import br.com.fiap.apiproduction.entrypoint.dto.response.ProductionResponse;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/production")
@AllArgsConstructor
public class ProductionController {

    private final ProductionUseCase orderUseCase;

    @GetMapping("/orders-queue")
    public ResponseEntity<JsonNode> getOrdersQueue() {
        return new ResponseEntity<>(orderUseCase.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductionResponse>> getAllProductions() {
        return new ResponseEntity<>(
                orderUseCase.getAllProductions()
                        .stream()
                        .map(ProductionResponse::fromClientResponse)
                        .toList(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductionResponse> getProductionById(@PathVariable String id) {
        return new ResponseEntity<>(
                ProductionResponse.fromClientResponse(orderUseCase.getProductionByProductionId(id)),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduction(@RequestBody ProductionRequest request) {
        orderUseCase.createProduction(request.fromRequestProduction());
        return new ResponseEntity<>("Produção criada com sucesso!", HttpStatus.OK);
    }
}
