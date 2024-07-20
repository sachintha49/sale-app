package com.pos.point_of_sale.service.impl;

import com.pos.point_of_sale.dto.paginated.PaginatedResponseItemDto;
import com.pos.point_of_sale.dto.request.ItemSaveRequestDto;
import com.pos.point_of_sale.dto.response.ItemGetResponseDto;
import com.pos.point_of_sale.entity.Item;
import com.pos.point_of_sale.exception.NotFoundException;
import com.pos.point_of_sale.repository.ItemRepo;
import com.pos.point_of_sale.service.ItemService;
import com.pos.point_of_sale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDto itemSaveRequestDto) {
        /*Here we used model mapper to map the dto into entity*/
        Item item = modelMapper.map(itemSaveRequestDto, Item.class);
        item.setActive(true);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemId() + " saved successfully!";
        } else {
            throw new DuplicateKeyException("Already Added!");
        }
    }

    /*Model mapper eka use karala entity eka dto ekata convert karanawa*/
    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatus(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameAndIsActive(itemName, true);
        if (!items.isEmpty()){
            // dakunu peththe tika wam peththata dagannawa. a kiyanne items tika TypeToken eken hadaganna list ekata danna kiyala kiyanne
            List<ItemGetResponseDto> itemGetResponseDtos = modelMapper.map(items, new TypeToken<List<ItemGetResponseDto>>
                    (){}.getType());
            return itemGetResponseDtos;
        }else {
            throw new RuntimeException("Not found!");
        }
    }

    /*Map Struct eka use karala entity eka dto ekata convert karanawa*/
    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatusByMatStruct(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameAndIsActive(itemName, true);
        if (!items.isEmpty()){
            // dakunu peththe tika wam peththata dagannawa. a kiyanne items tika TypeToken eken hadaganna list ekata danna kiyala kiyanne
            List<ItemGetResponseDto> itemGetResponseDtos = itemMapper.entityListToDtoList(items);
            return itemGetResponseDtos;
        }else {
            throw new RuntimeException("Not found!");
        }
    }

    @Override
    public List<ItemGetResponseDto> getItemsByActiveStatus(boolean activeStatus) {
        List<Item> items = itemRepo.findAllByIsActive(activeStatus);
        if (!items.isEmpty()){
            // dakunu peththe tika wam peththata dagannawa. a kiyanne items tika TypeToken eken hadaganna list ekata danna kiyala kiyanne
            List<ItemGetResponseDto> itemGetResponseDtos = itemMapper.entityListToDtoList(items);
            return itemGetResponseDtos;
        }else {
            throw new NotFoundException("Not found!");
        }
    }

    @Override
    public PaginatedResponseItemDto getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        // methana page eka 1 unoth size eka 5 unoth eken enne dewani records 5 adala logics ekata anuwa. and page eka set wenne 0 idan
        Page<Item> items = itemRepo.findAllByIsActive(activeStatus, PageRequest.of(page,size));
        if (items.getSize() < 1){
            throw new NotFoundException("No data found!");
        }
        PaginatedResponseItemDto paginatedResponseItemDto = new PaginatedResponseItemDto(
                itemMapper.listDtoToPage(items),
                2
        );
        return paginatedResponseItemDto;
    }
}
