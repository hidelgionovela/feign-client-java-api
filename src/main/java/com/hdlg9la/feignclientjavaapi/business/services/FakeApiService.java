package com.hdlg9la.feignclientjavaapi.business.services;

import com.hdlg9la.feignclientjavaapi.apiv1.dto.ProductsDTO;
import com.hdlg9la.feignclientjavaapi.business.converter.ProductConverter;
import com.hdlg9la.feignclientjavaapi.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient client;
    private final ProductConverter converter;
    private final ProductService productService;

    public List<ProductsDTO> findProducts() {
//        Para nao salvar mais de uma vez o mesmo produto

        try {

            List<ProductsDTO> dto = client.findProductsList();

            dto.forEach(product -> {
                        Boolean response = productService.existsByName(product.getTitle());
                        if(response.equals(false)) {
                            productService.saveProduct(converter.toEntity(product));
                        }

                    }

            );
            return converter.toListDTO(productService.findAllProducts());

        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving all products and save in DB");
        }




    }
}
