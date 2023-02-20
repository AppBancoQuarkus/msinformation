package com.nttd.service;

import com.nttd.dto.CustomerDto;
import com.nttd.dto.ResponseDto;

public interface InformationService {
    ResponseDto getProducts(CustomerDto customerDto);
}
