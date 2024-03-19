package br.com.fiap.apiproduction.dataprovider.Kafka;


import br.com.fiap.apiproduction.dataprovider.Kafka.message.OrderMessage;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.CommonClientConfigs.SECURITY_PROTOCOL_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;
import static org.apache.kafka.common.config.SaslConfigs.SASL_JAAS_CONFIG;
import static org.apache.kafka.common.config.SaslConfigs.SASL_MECHANISM;

@EnableKafka
@Configuration
public class KafkaSaleProducerConfig {

    private static final String CONFLUENT_CLOUD_BOOTSTRAP_SERVERS = "pkc-12576z.us-west2.gcp.confluent.cloud:9092";
    private static final String CONFLUENT_CLOUD_API_KEY = "KEK7GNAS4BPKFV2H";
    private static final String CONFLUENT_CLOUD_API_SECRET = "tZoja1y9BL/6J/a+sB9jThULD0fm1VVp/DDURzj2yHPMPvfx0PUL+PASMp9a4xOy";

    @Bean
    public ProducerFactory<String, OrderMessage> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(BOOTSTRAP_SERVERS_CONFIG, CONFLUENT_CLOUD_BOOTSTRAP_SERVERS);
        props.put(SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + CONFLUENT_CLOUD_API_KEY + "\" password=\"" + CONFLUENT_CLOUD_API_SECRET + "\";");
        props.put(SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        props.put(SASL_MECHANISM, "PLAIN");
        props.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(VALUE_DESERIALIZER_CLASS_CONFIG, CustomDeserializer.class);
        props.put(AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, OrderMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
