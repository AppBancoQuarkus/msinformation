package com.nttd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.nttd.api.AuditApi;
import com.nttd.api.OperationApi;
import com.nttd.api.response.AccountResponse;
import com.nttd.api.response.OperationResponse;
import com.nttd.dto.CustomerDto;
import com.nttd.dto.ProductDto;
import com.nttd.dto.ResponseDto;
import com.nttd.service.InformationService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class InformationServiceImpl implements InformationService {

    @RestClient
    AuditApi auditApi;

    @RestClient
    OperationApi operationApi;

    @ConfigProperty(name = "mensaje.general")
    String mensajeGeneral;

    public ResponseDto getProducts(CustomerDto customerDto) {
        long customerId = Long.parseLong(customerDto.getCodigoCliente());
        OperationResponse operationRequest = operationApi.getProducts(customerId,
                true);
        if (operationRequest.getCode() == Integer.parseInt(Status.OK.toString())
                && operationRequest.getListaccount().size() > 0) {
            List<AccountResponse> accounts = operationRequest.getListaccount();
            List<ProductDto> products = new ArrayList<>();
            for (AccountResponse account : accounts) {
                ProductDto productDto = new ProductDto();

                productDto.setNombre(account.getDescription());
                productDto.setTipoProducto(account.getFlag_creation());
                productDto.setSaldo(account.getCurrent_amount());

                products.add(productDto);
            }
            return new ResponseDto(200, "OK", products);
        } else {
            return new ResponseDto(204, "OK, sin contenido.", "");
        }

    }

}
