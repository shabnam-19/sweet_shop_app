package com.sweetShop.Service

import com.sweetShop.entity.Items

interface ItemService {
    fun getAllItems(): List<Items>
    fun itemById(id: Int): Items
    fun saveOrUpdate(item: Items): Items
    fun delete(id: Int): Items
    fun getQuantity(quantity: Int): Items
}