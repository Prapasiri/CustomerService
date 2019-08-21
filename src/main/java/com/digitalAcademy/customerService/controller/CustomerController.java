package com.digitalAcademy.customerService.controller;


import com.digitalAcademy.customerService.model.Customer;
import com.digitalAcademy.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping("/list")
    public List<Customer> getAllCustomer() {
        return customerService.getCustomer();
    }

//    @RequestMapping(path = "/list")
//    public String getAllCustomer(){
////        CustomerService cs = new CustomerService();
////        return customerService.create(this.customerService);
//        return "";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        Customer customer = customerService.getCustomer(id);
        if (customer != null){
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer body){
        Customer customer = customerService.createCustomer(body);
        System.err.println("----------" + customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCustomer(@PathVariable Long id, @Valid @RequestBody Customer body) {
        body.setId(id);
        Customer customer = customerService.updateCustomer(id, body);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        // .build() must have because it has to build new Entity
        // .ok() -> 200
        // .notFound() -> 400
        return customerService.deleteById(id) ?
                ResponseEntity.ok().build():
                ResponseEntity.notFound().build();
    }

}
