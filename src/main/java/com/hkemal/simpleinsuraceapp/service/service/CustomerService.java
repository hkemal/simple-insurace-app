package com.hkemal.simpleinsuraceapp.service.service;

import com.hkemal.simpleinsuraceapp.service.dto.CustomerInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CustomerResultDTO;

import java.util.List;

public interface CustomerService extends SimpleCrudService<CustomerInputDTO, CustomerResultDTO> {
    List<CustomerResultDTO> getAll();

    CustomerResultDTO getOne(Long id) throws Exception;

    void delete(Long id) throws Exception;
}
