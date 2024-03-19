package br.com.fiap.apiproduction.core;

import br.com.fiap.apiproduction.dataprovider.repository.entity.ProductionEntity;
import br.com.fiap.apiproduction.entrypoint.dto.response.ProductionResponse;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;

public class Production {

    private ObjectId productionId;

    private String clientCpf;

    private UUID orderId;

    private Boolean isPaymentReceived;

    private Double orderPrice;

    private List<UUID> productId;

    public Production(ObjectId productionId, String clientCpf, UUID orderId, Boolean isPaymentReceived, Double orderPrice, List<UUID> productId) {
        this.productionId = productionId;
        this.clientCpf = clientCpf;
        this.orderId = orderId;
        this.isPaymentReceived = isPaymentReceived;
        this.orderPrice = orderPrice;
        this.productId = productId;
    }

    public Production(String clientCpf, UUID orderId, Boolean isPaymentReceived, Double orderPrice, List<UUID> productId) {
        this.clientCpf = clientCpf;
        this.orderId = orderId;
        this.isPaymentReceived = isPaymentReceived;
        this.orderPrice = orderPrice;
        this.productId = productId;
    }

    public Production() {

    }

    public ObjectId getProductionId() {
        return productionId;
    }

    public void setProductionId(ObjectId productionId) {
        this.productionId = productionId;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Boolean getPaymentReceived() {
        return isPaymentReceived;
    }

    public void setPaymentReceived(Boolean paymentReceived) {
        isPaymentReceived = paymentReceived;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public List<UUID> getProductId() {
        return productId;
    }

    public void setProductId(List<UUID> productId) {
        this.productId = productId;
    }

    public ProductionResponse toResponse() {
        return new ProductionResponse(this.getProductionId().toHexString(), this.clientCpf, this.getOrderId(), this.getPaymentReceived(),
                this.getOrderPrice(), this.getProductId());
    }

    public ProductionEntity toEntity() {
        return new ProductionEntity(
                this.productionId
                ,this.clientCpf
                ,this.orderId
                ,this.isPaymentReceived
                ,this.orderPrice
                ,this.productId);
    }
}
