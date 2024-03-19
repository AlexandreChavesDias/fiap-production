package br.com.fiap.apiproduction.dataprovider.Kafka.send;

import br.com.fiap.apiproduction.dataprovider.Kafka.OrderEvent;
import br.com.fiap.apiproduction.dataprovider.Kafka.message.OrderMessage;

public interface SendToKafkaOutputPort {

    void send(OrderMessage order, OrderEvent event);

}
