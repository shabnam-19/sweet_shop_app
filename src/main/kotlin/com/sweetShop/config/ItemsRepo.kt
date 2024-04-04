package com.sweetShop.config

import com.sweetShop.entity.Items
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
public interface ItemsRepo: CrudRepository<Items, Int> {

    @Query(value = "select * from items where quantity > :quantity", nativeQuery = true)
    fun getQuantity(@Param("quantity") quantity: Int): Items
}