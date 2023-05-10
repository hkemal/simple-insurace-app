package com.hkemal.simpleinsuraceapp.webRest;

import com.hkemal.simpleinsuraceapp.service.dto.CustomerInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CustomerResultDTO;
import com.hkemal.simpleinsuraceapp.service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    @Autowired
    CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<CustomerResultDTO> createCustomer(@RequestBody CustomerInputDTO customerInputDTO) throws URISyntaxException {
        log.debug("REST request to save Customer : {}", customerInputDTO);
        CustomerResultDTO result = (CustomerResultDTO) customerService.save(customerInputDTO);
        return ResponseEntity.created(new URI("/api/customers/" + result.getId()))
                .body(result);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerResultDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerInputDTO customerInputDTO) throws Exception {
        log.debug("REST request to update Customer : {}", customerInputDTO);
        CustomerResultDTO result = (CustomerResultDTO) customerService.update(id, customerInputDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResultDTO>> getAllCustomers() throws URISyntaxException {
        log.debug("REST request to get all Customers");
        List<CustomerResultDTO> results = (List<CustomerResultDTO>) customerService.getAll();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResultDTO> getOneCustomer(@PathVariable Long id) throws Exception {
        log.debug("REST request to get all Customers");
        CustomerResultDTO result = (CustomerResultDTO) customerService.getOne(id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) throws Exception {
        customerService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
