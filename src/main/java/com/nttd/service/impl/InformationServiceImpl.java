package com.nttd.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.nttd.api.AuditApi;
import com.nttd.api.OperationApi;
import com.nttd.api.response.AccountResponse;
import com.nttd.dto.CustomerDto;
import com.nttd.service.InformationService;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InformationServiceImpl implements InformationService {

    @RestClient
    AuditApi auditApi;

    @RestClient
    OperationApi operationApi;

    @ConfigProperty(name = "mensaje.general")
    String mensajeGeneral;

    @ConfigProperty(name = "exception.general")
    String exceptionGeneral;
    

    @Override
    public Multi<List<AccountResponse>> getProducts(CustomerDto customerDto) {
 
            return operationApi.getProducts(customerDto.getCodigoCliente(),true)
                .onItem().                
                transformToMulti((prod) -> {
                    /* 
                    if(prod.getCode() == Response.Status.OK.getStatusCode()){
                        obj.setCode(Response.Status.OK.getStatusCode());
                        obj.setDescription(mensajeGeneral);
                        List<AccountResponse> lista = new ArrayList<>();
                        for(AccountResponse item : prod.getListaccount()){
                            lista.add(new AccountResponse(
                                item.getFlag_creation(),item.getCurrent_amount(),
                                item.getStarting_amount()));                          
                        }
                        obj.setListaccount(lista);
                    }else {
                        obj.setCode(Response.Status.BAD_REQUEST.getStatusCode());
                        obj.setDescription(exceptionGeneral);
                    }
                    return Uni.createFrom().item(obj);*/
                    List<AccountResponse> lista = new ArrayList<>();
                    for(AccountResponse item : prod.getListaccount()){
                        lista.add(new AccountResponse(
                            item.getFlag_creation(),item.getCurrent_amount(),
                            item.getStarting_amount()));                          
                    }
                    return Multi.createFrom().item(lista);
                });            
      
                
                    /*AccountResponse obj = new AccountResponse();
                    obj.setFlag_account(account.getFlag_account());
                    return obj;*/

               /* });
                .call((obj) -> {


                    return Uni.createFrom().item(new ResponseDto(200, "OK", products));
                });*/
        
        
    /*
            List<AccountResponse> accounts = operationRequest.getListaccount();
            List<ProductDto> products = new ArrayList<>();
            for (AccountResponse account : accounts) {
                ProductDto productDto = new ProductDto();

                productDto.setNombre(account.getDescription());
                productDto.setTipoProducto(account.getFlag_creation());
                productDto.setSaldo(account.getCurrent_amount());

                products.add(productDto);
            } */
        

    }

}
