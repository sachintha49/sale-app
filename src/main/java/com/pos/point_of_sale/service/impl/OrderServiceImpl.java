package com.pos.point_of_sale.service.impl;

import com.pos.point_of_sale.dto.request.RequestOrderSaveDto;
import com.pos.point_of_sale.entity.Customer;
import com.pos.point_of_sale.entity.Order;
import com.pos.point_of_sale.entity.OrderDetails;
import com.pos.point_of_sale.exception.NotFoundException;
import com.pos.point_of_sale.repository.CustomerRepo;
import com.pos.point_of_sale.repository.ItemRepo;
import com.pos.point_of_sale.repository.OrderDetailRepo;
import com.pos.point_of_sale.repository.OrderRepo;
import com.pos.point_of_sale.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDto itemSaveRequestDto) {
        // Creating an Order using the Builder pattern
        Order order = Order.builder()
                .customer(customerRepo.getReferenceById(itemSaveRequestDto.getCustomer()))
                .date(itemSaveRequestDto.getDate())
                .total(itemSaveRequestDto.getTotal()).build();

        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {

            List<OrderDetails> orderDetails = modelMapper.map(itemSaveRequestDto.getOrderDetails(), new TypeToken<List<OrderDetails>>() {

            }.getType());

            for (int i = 0; i < orderDetails.size(); i++) {
                orderDetails.get(i).setOrder(order);
                orderDetails.get(i).setItems(itemRepo.getReferenceById(itemSaveRequestDto.getOrderDetails().get(i).getItems()));
            }

            if (orderDetails.size() > 0) {
                orderDetailRepo.saveAll(orderDetails);
            }
            return "Saved";
        }
       return null;
    }
}
