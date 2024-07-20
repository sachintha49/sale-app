package com.pos.point_of_sale.controller;

import com.pos.point_of_sale.dto.paginated.PaginatedResponseItemDto;
import com.pos.point_of_sale.dto.request.ItemSaveRequestDto;
import com.pos.point_of_sale.dto.response.ItemGetResponseDto;
import com.pos.point_of_sale.service.ItemService;
import com.pos.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping(
//            path = {"/save"}
//    )
//    public String saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto){
//        String message = itemService.saveItem(itemSaveRequestDto);
//        return message;
//    }

    @PostMapping(
            path = {"/save"}
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto) {
        String message = itemService.saveItem(itemSaveRequestDto);

//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                new StandardResponse(201, "Success!", message), HttpStatus.CREATED
//        );
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success!", message), HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDto> itemDtos = itemService.getItemByNameAndStatus(itemName);
        return itemDtos;
    }

    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatusByMapStruct(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDto> itemDtos = itemService.getItemByNameAndStatusByMatStruct(itemName);
        return itemDtos;
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
     //   List<ItemGetResponseDto> itemDtos = itemService.getItemsByActiveStatus(activeStatus,page,size);
        PaginatedResponseItemDto paginatedResponseItemDto = itemService.getItemByActiveStatusWithPaginated(activeStatus,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success!", paginatedResponseItemDto), HttpStatus.OK
        );
    }
}
