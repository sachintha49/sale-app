package com.pos.point_of_sale.controller;

import com.pos.point_of_sale.dto.request.ItemSaveRequestDto;
import com.pos.point_of_sale.dto.request.RequestOrderSaveDto;
import com.pos.point_of_sale.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @PostMapping(
            path = {"/save"}
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDto itemSaveRequestDto) {

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success!", 3), HttpStatus.CREATED
        );
    }
}
