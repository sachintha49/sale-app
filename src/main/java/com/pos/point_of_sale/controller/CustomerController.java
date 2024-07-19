package com.pos.point_of_sale.controller;

import com.pos.point_of_sale.dto.CustomerDto;
import com.pos.point_of_sale.dto.request.CustomerUpdateDto;
import com.pos.point_of_sale.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Operation(summary = "Create a new customer")
    @ApiResponse(responseCode = "201", description = "Customer has been saved successfully!")
    public String saveCustomer(@RequestBody CustomerDto customerDto){
        /*apita json ekak java obj ekakta bind wenawa wagema. clinet ekata yawannath one json ekak vidiyta*/
        /*ekata RestController eke athule inne ResponseBody eka wede karala denawa java eka json ekakta convert karanawa. nikan controller eka vitharak dammoth front end ekat yanne ne*/
        String returnMessage = customerService.saveCustomer(customerDto);
        return returnMessage;
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto){
        customerService.updateCustomer(customerUpdateDto);
        return "updated";
    }

    /*me path ekata call karaddi params ewanna one idk iyala front end eken. key eka id eka and value eka
    * eka alladdith eka a namama htiyenna one nehtham eka allanen ne.
    *
    * neththam @RequestParam eka use karala a value eka allala aluth value ekata assign karanna puluwn*/
    @GetMapping(path = "/get-by-id", params = "id")
    @Operation(summary = "Get a customer by id", description = "Return a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found!"),
            @ApiResponse(responseCode = "404", description = "Customer not found!!")
    })
    public CustomerDto getCustomerById(@RequestParam(value = "id") int customerId){
    CustomerDto customerDto = customerService.getCustomerById(customerId);
        return customerDto;
    }

    @GetMapping(
            path = "/get-all-customers"
    )
    @Operation(summary = "Get all customers", description = "Return list of customers")
    @ApiResponse(responseCode = "200", description = "Customer found!")
    public List<CustomerDto> getAllCustomers(){
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }


}
