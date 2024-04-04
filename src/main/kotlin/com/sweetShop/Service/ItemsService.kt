package com.sweetShop.Service

import com.sweetShop.config.ItemsRepo
import com.sweetShop.entity.Items
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemsService(@field:Autowired private val itemRepo: ItemsRepo) : ItemService{

    override fun getAllItems(): List<Items> {
        return itemRepo.findAll().toList()
    }

    override fun itemById(id: Int): Items {
        return itemRepo.findById(id).orElse(null)
    }

    override fun saveOrUpdate(item: Items): Items {
        return itemRepo.save(item)
    }

    override fun delete(id: Int): Items {
        var deletedItem: Items? = null
        try{
            deletedItem = itemRepo.findById(id).orElse(null)
            if(deletedItem == null)
                throw Exception("Item is not available")
            else
                itemRepo.deleteById(id)
        }catch(ex: Exception){
            throw ex
        }
        return deletedItem
    }

    override fun getQuantity(quantity: Int): Items {
        return itemRepo.getQuantity(quantity)
    }
}