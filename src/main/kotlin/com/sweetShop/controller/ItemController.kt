package com.sweetShop.controller

import com.sweetShop.Service.ItemsService
import com.sweetShop.entity.Items
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/items")
class ItemController(@field:Autowired private val itemService: ItemsService) {

    @GetMapping("/allitems")
    fun getAllItems(): ResponseEntity<List<Items>> {
        var items: List<Items>? = null
        try{
            items = itemService.getAllItems()
        }
        catch(e: Exception){
            e.message
        }
        return ResponseEntity<List<Items>>(items, HttpStatus.OK)
    }

    @GetMapping("/getitems/{id}")
    fun getItemsById(@PathVariable("id") id: Int): ResponseEntity<Items> {
        var items: Items? = null
        try{
            items = itemService.itemById(id)
        }
        catch(e: Exception){
            e.message
        }
        return ResponseEntity<Items>(items, HttpStatus.OK)
    }

    @GetMapping("/getitemsByquantity/{quantity}")
    fun getItemsByQuantity(@PathVariable("quantity") quantity: Int): ResponseEntity<Items> {
        var items: Items? = null
        try{
            items = itemService.getQuantity(quantity)
        }
        catch(e: Exception){
            e.message
        }
        return ResponseEntity<Items>(items, HttpStatus.OK)
    }

    @PostMapping("/update")
    fun saveOrUpdate(@RequestBody item: Items): ResponseEntity<Items> {
        var items: Items? = null
        try{
            items = itemService.saveOrUpdate(item)
        }
        catch(e: Exception){
            e.message
        }
        return ResponseEntity<Items>(items, HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteItemsById(@PathVariable("id") id: Int): ResponseEntity<Items> {
        var items: Items? = null
        try{
            items = itemService.delete(id)
        }
        catch(e: Exception){
            e.message
        }
        return ResponseEntity<Items>(items, HttpStatus.OK)
    }
}