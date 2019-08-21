package com.digitalAcademy.customerService.service;

import com.digitalAcademy.customerService.model.Customer;
import com.digitalAcademy.customerService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer body){
        return customerRepository.save(body);
    }

//    public String getAllCustomer(){
//
//        return "customer data naja";
//    }

    public Customer getCustomer(Long id){
        return customerRepository.findAllById(id);
    }

    public Customer updateCustomer(Long id, Customer customer){
        // short if (can't have else if)
        // check sentense ? true : false
        return customerRepository.findAllById(id) != null ?
                customerRepository.save(customer) :
                customerRepository.findAllById(id);
    }

    public boolean deleteById(Long id){
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e){
            return  false;
        }
    }

}
