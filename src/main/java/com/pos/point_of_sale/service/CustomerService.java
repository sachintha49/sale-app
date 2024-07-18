package com.pos.point_of_sale.service;

import com.pos.point_of_sale.dto.CustomerDto;
import com.pos.point_of_sale.dto.request.CustomerUpdateDto;

public interface CustomerService {
   String saveCustomer(CustomerDto customerDto);

   void updateCustomer(CustomerUpdateDto customerUpdateDto);

   CustomerDto getCustomerById(int customerId);
}
