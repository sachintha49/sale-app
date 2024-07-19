package com.pos.point_of_sale.service.impl;

import com.pos.point_of_sale.dto.CustomerDto;
import com.pos.point_of_sale.dto.request.CustomerUpdateDto;
import com.pos.point_of_sale.entity.Customer;
import com.pos.point_of_sale.repository.CustomerRepo;
import com.pos.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                customerDto.getCustomerSalary(),
                customerDto.getCustomerAddress(),
                customerDto.isActive()
        );
        customerRepo.save(customer);
        return "";
    }

    @Override
    public void updateCustomer(CustomerUpdateDto customerUpdateDto) {
        if (customerRepo.existsById(customerUpdateDto.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDto.getCustomerId());
            customer.setCustomerName(customerUpdateDto.getCustomerName());
            customer.setCustomerAddress(customerUpdateDto.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDto.getCustomerSalary());

            customerRepo.save(customer);
        }else{
            throw new RuntimeException("no data found");
        }
    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)){
        Customer customer = customerRepo.getReferenceById(customerId);
        CustomerDto customerDto = new CustomerDto(
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getCustomerAddress(),
                customer.getCustomerSalary(),
                customer.getContactNumber(),
                customer.getNic(),
                customer.isActive()
        );
            return customerDto;
        }else{
            throw new RuntimeException("no data found");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerDto> customerList = new ArrayList<>();

        for (Customer customer : customers){
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerList.add(customerDto);
        }
        return customerList;
    }
}
