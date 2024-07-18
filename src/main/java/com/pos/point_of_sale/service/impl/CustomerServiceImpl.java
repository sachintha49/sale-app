package com.pos.point_of_sale.service.impl;

import com.pos.point_of_sale.dto.CustomerDto;
import com.pos.point_of_sale.entity.Customer;
import com.pos.point_of_sale.repository.CustomerRepo;
import com.pos.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(
                customerDto.getCustomerId(),
                customerDto.getCustomerName(),
                customerDto.getCustomerAddress(),
                customerDto.getContactNumber(),
                customerDto.getCustomerAddress(),
                customerDto.isActive()
        );
        customerRepo.save(customer);
        return "";
    }
}
