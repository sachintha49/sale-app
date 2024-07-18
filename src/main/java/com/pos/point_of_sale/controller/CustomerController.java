package com.pos.point_of_sale.controller;

import com.pos.point_of_sale.dto.CustomerDto;
import com.pos.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*meya rest controller ekak kiyala define karanne menna me annotation eken
* meka hedila thiyenne @Controller + @ResonseBody kiyana annotation deka ekathu wela*/
@RestController
/*me controller eka unique karanna puluwan Request Mapping annotation eka use karala*/
@RequestMapping("api/v1/customer")
/*spring walin dena default protection ekak wena origin ekak idan mekata access kranna beri wenna.
* specific front end ekakin call kranna hadanna puluwan. apita "www.facebook.com' walin ena ewa witharak ganna kiyala kiyanna puluwan*/
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*requestBody eken karanne json object ekaka idan java object ekakata convert karana eka*/
    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDto customerDto){
        /*apita json ekak java obj ekakta bind wenawa wagema. clinet ekata yawannath one json ekak vidiyta*/
        /*ekata RestController eke athule inne ResponseBody eka wede karala denawa java eka json ekakta convert karanawa. nikan controller eka vitharak dammoth front end ekat yanne ne*/
        customerService.saveCustomer(customerDto);
        return customerDto.getCustomerName();
    }
}