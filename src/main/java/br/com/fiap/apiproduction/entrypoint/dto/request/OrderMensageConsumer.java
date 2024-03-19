package br.com.fiap.apiproduction.entrypoint.dto.request;

import br.com.fiap.apiproduction.dataprovider.Kafka.message.OrderMessage;

import java.util.List;
import java.util.UUID;

public record OrderMensageConsumer(String clientCpf, UUID orderId, Boolean isPaymentReceived, Double orderPrice, List<UUID> productId) {

    public OrderMessage fromRequestProduction() {
        return new OrderMessage(clientCpf, orderId, isPaymentReceived, orderPrice, productId);
    }

}