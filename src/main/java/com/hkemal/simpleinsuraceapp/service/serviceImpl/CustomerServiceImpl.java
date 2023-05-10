package com.hkemal.simpleinsuraceapp.service.serviceImpl;

import com.hkemal.simpleinsuraceapp.entity.Customer;
import com.hkemal.simpleinsuraceapp.repository.CustomerRepository;
import com.hkemal.simpleinsuraceapp.service.dto.CustomerInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CustomerResultDTO;
import com.hkemal.simpleinsuraceapp.service.mapper.CustomerMapper;
import com.hkemal.simpleinsuraceapp.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public CustomerResultDTO save(CustomerInputDTO customerInputDTO) {
        Customer customer = customerMapper.toEntity(customerInputDTO);
        customer = customerRepository.save(customer);
        CustomerResultDTO result = customerMapper.toDto(customer);
        return result;
    }

    @Override
    public CustomerResultDTO update(Long id, CustomerInputDTO customerInputDTO) throws Exception {
        this.getOne(id);
        Customer customer = customerMapper.toEntity(customerInputDTO);
        customer.setId(id);
        customer = customerRepository.save(customer);
        CustomerResultDTO result = customerMapper.toDto(customer);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResultDTO> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toDto(customers);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResultDTO getOne(Long id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customerMapper.toDto(customer.get());
        } else {
            throw new Exception();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        this.getOne(id);
        customerRepository.deleteById(id);
    }
}
