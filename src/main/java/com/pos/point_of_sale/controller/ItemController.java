package com.pos.point_of_sale.controller;

import com.pos.point_of_sale.dto.request.ItemSaveRequestDto;
import com.pos.point_of_sale.dto.response.ItemGetResponseDto;
import com.pos.point_of_sale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(

            path = {"/save"}
    )
    public String saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto){
        String message = itemService.saveItem(itemSaveRequestDto);
        return message;
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDto> itemDtos = itemService.getItemByNameAndStatus(itemName);
        return itemDtos;
    }

    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatusByMapStruct(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDto> itemDtos = itemService.getItemByNameAndStatusByMatStruct(itemName);
        return itemDtos;
    }
}
