package com.nttd.resource;

import com.nttd.dto.CustomerDto;
import com.nttd.dto.ResponseDto;
import com.nttd.service.InformationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/information")
public class InformationResource {

    @Inject
    InformationService informationService;

    @GET
    public ResponseDto getProducts(CustomerDto customerDto) {
        return informationService.getProducts(customerDto);
    }

}
