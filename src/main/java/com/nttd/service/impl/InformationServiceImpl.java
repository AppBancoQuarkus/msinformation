package com.nttd.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.nttd.api.AuditApi;
import com.nttd.api.OperationApi;
import com.nttd.api.request.OperationRequest;
import com.nttd.api.response.OperationResponse;
import com.nttd.dto.CustomerDto;
import com.nttd.dto.ProductDto;
import com.nttd.dto.ResponseDto;
import com.nttd.service.InformationService;

import jakarta.inject.Inject;

public class InformationServiceImpl implements InformationService {

    @Inject
    AuditApi auditApi;

    @Inject
    OperationApi operationApi;

    @Override
    public ResponseDto getProducts(CustomerDto customerDto) {
        OperationRequest request = new OperationRequest(customerDto.getCodigoCliente());
        OperationResponse operationResponse = operationApi.getProducts(request);
        List<ProductDto> products = new ArrayList<>();
        return new ResponseDto(200, "asdasd", products);
    }

    ResponseDto toResponseDto(OperationResponse operationResponse) {
        return new ResponseDto();
    }

}
