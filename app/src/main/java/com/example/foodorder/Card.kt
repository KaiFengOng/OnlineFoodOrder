package com.example.foodorder

import kotlin.math.exp

class Card {

    //card class
    var cCardNum: String? = null
    var expDate: String? = null
    var cvcNum: String? = null
    var quantity: Int = 0
    var totalChargeIncludeDelivery: Double = 0.00

    //constructor with parameter list
    constructor(cCardNum: String, expDate: String, cvcNum: String, quantity: Int, totalChargeIncludeDelivery: Double)
    {
        this.cCardNum = cCardNum
        this.expDate = expDate
        this.cvcNum = cvcNum
        this.quantity = quantity
        this.totalChargeIncludeDelivery = totalChargeIncludeDelivery
    }

    //default constructor
    constructor()
    {
    }
}