package com.pos.point_of_sale.controller;

import com.pos.point_of_sale.dto.request.ItemSaveRequestDto;
import com.pos.point_of_sale.dto.request.RequestOrderSaveDto;
import com.pos.point_of_sale.service.OrderService;
import com.pos.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(
            path = {"/save"}
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDto itemSaveRequestDto) {
String id = orderService.addOrder(itemSaveRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id, 3), HttpStatus.CREATED
        );
    }

    @GetMapping(
            params = {"stateType","page","size"},
            path = {"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = )
    ){
        return null;
    }
}
