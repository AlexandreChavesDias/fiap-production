package br.com.fiap.apiproduction.dataprovider.Kafka.consumer;

import br.com.fiap.apiproduction.core.Production;
import br.com.fiap.apiproduction.core.usecase.ProductionUseCase;
import br.com.fiap.apiproduction.dataprovider.Kafka.OrderEvent;
import br.com.fiap.apiproduction.dataprovider.Kafka.message.OrderMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ReceivedApprovedPaymentRequest {

    private final ProductionUseCase orderUseCase;

   public ReceivedApprovedPaymentRequest(ProductionUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }
@KafkaListener(topics ="tp-saga-orders",groupId = "orders")
public void receive(OrderMessage orderMessage){
    System.out.println("Pedido adicionado a Lista de pedidos1------------------------------------------------------"+orderMessage.getOrderEvent());
    if(OrderEvent.ORDER_STARTED.equals(orderMessage.getOrderEvent())){
        orderUseCase.createProduction(new Production(orderMessage.getClientCpf(),
                orderMessage.getOrderId(), true, orderMessage.getOrderPrice(), orderMessage.getProductId()) );
        System.out.println("Pedido adicionado a Lista de pedidos2------------------------------------------------------");
        }

}}


