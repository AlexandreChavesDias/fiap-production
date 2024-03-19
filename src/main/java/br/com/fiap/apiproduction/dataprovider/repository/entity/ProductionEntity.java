package br.com.fiap.apiproduction.dataprovider.repository.entity;

import br.com.fiap.apiproduction.core.Production;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document
public class ProductionEntity {

    @Id
    @Field(name = "_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId productionId;

    private String clientCpf;

    private UUID orderId;

    private Boolean isPaymentReceived;

    private Double orderPrice;

    private List<UUID> productId;

    public ProductionEntity() {
    }

    public ProductionEntity(Production production) {
        this.productId = production.getProductId();
        this.clientCpf = production.getClientCpf();
        this.orderId = production.getOrderId();
        this.isPaymentReceived = production.getPaymentReceived();
        this.orderPrice = production.getOrderPrice();
        this.productId = production.getProductId();
    }

    public ProductionEntity(ObjectId productionId, String clientCpf, UUID orderId, Boolean isPaymentReceived, Double orderPrice, List<UUID> productId) {
        this.productionId = productionId;
        this.clientCpf = clientCpf;
        this.orderId = orderId;
        this.isPaymentReceived = isPaymentReceived;
        this.orderPrice = orderPrice;
        this.productId = productId;

    }

    public Production toProduction() {
        return new Production(
                this.productionId,
                this.clientCpf,
                this.orderId,
                this.isPaymentReceived,
                this.orderPrice,
                this.productId
        );
    }

}
