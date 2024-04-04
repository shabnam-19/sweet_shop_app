package com.sweetShop.entity

import jakarta.persistence.*

@Entity
@Table(name = "items")
public data class Items(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        val name: String,
        val price: Int,
        val quantity: Int,
) {
    public constructor(name: String, price: Int, quantity: Int, sellerId: Int) : this(0, name, price, quantity) {
    }
    constructor() : this(0, "", 0, 0)
    override fun toString(): String {
        return "Items(id=$id, name='$name', price=$price, quantity=$quantity)"
    }

}