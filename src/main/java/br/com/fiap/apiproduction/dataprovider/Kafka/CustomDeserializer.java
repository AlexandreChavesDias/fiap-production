package br.com.fiap.apiproduction.dataprovider.Kafka;

import br.com.fiap.apiproduction.dataprovider.Kafka.message.OrderMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;


public class CustomDeserializer implements Deserializer<OrderMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public OrderMessage deserialize(String topic, byte[] data) {
        try {
            if (data == null || data.length == 0) {
                return null;
            }
            return objectMapper.readValue(data, OrderMessage.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to OrderMessage", e);
        }
    }
}
