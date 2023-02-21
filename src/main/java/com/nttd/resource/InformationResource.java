package com.nttd.resource;

import java.util.List;

import com.nttd.api.response.AccountResponse;
import com.nttd.api.response.OperationResponse;
import com.nttd.dto.CustomerDto;
import com.nttd.service.InformationService;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/information")
public class InformationResource {

    @Inject
    InformationService informationService;

    @GET
    public Multi<List<AccountResponse>> getProducts(CustomerDto customerDto) {
        return informationService.getProducts(customerDto);
    }

}
