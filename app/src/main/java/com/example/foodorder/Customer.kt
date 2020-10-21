package com.example.foodorder

class Customer {

    //customer details
    var Name: String? = null
    var Contact: String? = null
    var email: String? = null

    //constructor with parameter
    constructor(Name: String, Contact: String, email: String)
    {
        this.Name = Name
        this.Contact = Contact
        this.email = email
    }

    //default constructor
    constructor(){}

}