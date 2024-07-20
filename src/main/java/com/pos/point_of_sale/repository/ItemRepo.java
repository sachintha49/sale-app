package com.pos.point_of_sale.repository;

import com.pos.point_of_sale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByItemNameAndIsActive(String itemName, boolean b);

    List<Item> findAllByIsActive(boolean activeStatus);
}
