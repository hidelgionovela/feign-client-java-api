package com.hdlg9la.feignclientjavaapi.apiv1.dto;

import com.hdlg9la.feignclientjavaapi.business.services.FakeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "fake-api")
public class FakeApiController {

    private final FakeApiService service;

    @GetMapping
    @Operation(summary = "Find all products", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search successfully performed."),
            @ApiResponse(responseCode = "500", description = "Error while fetching data during the search"),
    })
    public ResponseEntity<List<ProductsDTO>> findProducts(){
       return ResponseEntity.ok(service.findProducts());
    }


}
