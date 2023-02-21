package com.nttd.service;

import java.util.List;

import com.nttd.api.response.AccountResponse;
import com.nttd.api.response.OperationResponse;
import com.nttd.dto.CustomerDto;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface InformationService {
   
    public Multi<List<AccountResponse>> getProducts(CustomerDto customerDto);
}
