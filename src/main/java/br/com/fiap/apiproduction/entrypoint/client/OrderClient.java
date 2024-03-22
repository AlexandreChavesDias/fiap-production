package br.com.fiap.apiproduction.entrypoint.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "orderClient", url = "${ms-pedidos.api.url}")
public interface OrderClient {

    @GetMapping
    ResponseEntity<String> getAllOrders();
}