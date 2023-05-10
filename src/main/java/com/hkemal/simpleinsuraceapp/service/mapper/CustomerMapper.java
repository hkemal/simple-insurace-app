package com.hkemal.simpleinsuraceapp.service.mapper;

import com.hkemal.simpleinsuraceapp.entity.Customer;
import com.hkemal.simpleinsuraceapp.service.dto.CustomerInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CustomerResultDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerResultDTO, Customer> {

    CustomerResultDTO toDto(Customer customer);

    Customer toEntity(CustomerInputDTO customerInput);

    default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer country = new Customer();
        country.setId(id);
        return country;
    }
}
