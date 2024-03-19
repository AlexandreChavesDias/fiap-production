package br.com.fiap.apiproduction.entrypoint.dto.request;

import br.com.fiap.apiproduction.core.Production;

import java.util.List;
import java.util.UUID;

public record ProductionRequest(String clientCpf, UUID orderId, Boolean isPaymentReceived, Double orderPrice,
                                List<UUID> productId) {

    public Production fromRequestProduction() {
        return new Production(clientCpf, orderId, isPaymentReceived, orderPrice, productId);
    }

}