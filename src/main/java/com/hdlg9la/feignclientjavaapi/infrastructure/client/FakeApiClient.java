package com.hdlg9la.feignclientjavaapi.infrastructure.client;

import com.hdlg9la.feignclientjavaapi.apiv1.dto.ProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fake-api", url = "${fake-api.url:#{null}}")
public interface FakeApiClient {

    @GetMapping("/products")
    List<ProductsDTO> findProductsList();
}
