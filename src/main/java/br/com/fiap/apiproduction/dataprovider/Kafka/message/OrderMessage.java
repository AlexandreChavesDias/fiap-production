package br.com.fiap.apiproduction.dataprovider.Kafka.message;


import br.com.fiap.apiproduction.dataprovider.Kafka.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;


@Data
@ToString
@NoArgsConstructor
public class OrderMessage {

    private String productionId;

    private String clientCpf;

    private UUID orderId;

    private Boolean isPaymentReceived;

    private Double orderPrice;

    private List<UUID> productId;

    private OrderEvent orderEvent;

    public OrderMessage(String productionId, String clientCpf, UUID orderId, Boolean isPaymentReceived, Double orderPrice, List<UUID> productId, OrderEvent orderEvent) {
        this.productionId = productionId;
        this.clientCpf = clientCpf;
        this.orderId = orderId;
        this.isPaymentReceived = isPaymentReceived;
        this.orderPrice = orderPrice;
        this.productId = productId;
        this.orderEvent = orderEvent;
    }

    public OrderMessage(String clientCpf, UUID orderId, Boolean isPaymentReceived, Double orderPrice, List<UUID> productId) {
    }
}
