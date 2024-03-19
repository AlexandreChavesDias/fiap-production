package br.com.fiap.apiproduction.dataprovider.Kafka;

public enum OrderEvent {

    CREATE_ORDER,
    PROCESSING_PAYMENT,
    SUCCESS_PAYMENT,
    FAILED_PAYMENT,
    ORDER_STARTED,
    ORDER_FINISHED,
    ORDER_DELIVERED
}
