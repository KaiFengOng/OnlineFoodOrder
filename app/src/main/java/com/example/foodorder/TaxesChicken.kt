package com.example.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_taxeschicken.*

class TaxesChicken : AppCompatActivity() {

    //variable
    var HoneyButterBisc : Double = 21.00
    var Mexicanawrap : Double = 10.00
    var Nuggets : Double = 25.00
    var SpicyChicken : Double = 45.00
    var TaxWrap : Double = 13.00

    //total quantity for each meal
    var totalQuantityHoneyButterBisc : Int = 0
    var totalQuantityMexicanawrap : Int = 0
    var totalQuantityNuggets : Int = 0
    var totalQuantitySpicyChicken : Int = 0
    var totalQuantityTaxWrap : Int = 0

    //total each details of the set order price
    var totalChargeHoneyButterBisc : Double = 0.00
    var totalChargeMexicanawrap : Double = 0.00
    var totalChargeNuggets : Double = 0.00
    var totalChargeSpicyChicken : Double = 0.00
    var totalChargeTaxWrap : Double = 0.00

    var totalEstimateCharge : Double = 0.00  //to hold estimate amount charge when user place order
    var totalEstimateOrderQuantity : Int = 0 //to hold estimate amount quantity when user place order
    var userEmail: String? = null // to hold user email

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxeschicken)

        //to disable button function
        btnDecreaseHoneyButterBisc.isEnabled = false
        btnDecreaseMexicanawrap.isEnabled = false
        btnDecreaseNuggets.isEnabled = false
        btnDecreaseSpicyChicken.isEnabled = false
        btnDecreaseTaxWrap.isEnabled = false

        btnConfirmOrderTaxes.isVisible = false
        btnReorderTaxes.isVisible = false

        txtQuantityHoneyButterBisc.setText("Total Quantity: "+ totalQuantityHoneyButterBisc)
        txtQuantityMexicanawrap.setText("Total Quantity: " + totalQuantityMexicanawrap)
        txtQuantityNuggets.setText("Total Quantity: " + totalQuantityNuggets)
        txtQuantitySpicyChicken.setText("Total Quantity: " + totalQuantitySpicyChicken)
        txtQuantityTaxWrap.setText("Total Quantity: " + totalQuantityTaxWrap)

        //Increase button
        btnIncreaseHoneyButterBisc.setOnClickListener()
        {
            btnDecreaseHoneyButterBisc.isEnabled = true

            //to increase the quantity order
            totalQuantityHoneyButterBisc++

            //to calculate the charge
            txtQuantityHoneyButterBisc.setText("Total Quantity: " + totalQuantityHoneyButterBisc)
            totalChargeHoneyButterBisc = totalQuantityHoneyButterBisc * HoneyButterBisc
        }

        btnIncreaseMexicanawrap.setOnClickListener()
        {
            btnDecreaseMexicanawrap.isEnabled = true

            //to increase the quantity order
            totalQuantityMexicanawrap++

            //to calculate the charge
            txtQuantityMexicanawrap.setText("Total Quantity: " + totalQuantityMexicanawrap)
            totalChargeMexicanawrap = totalQuantityMexicanawrap * Mexicanawrap
        }

        btnIncreaseNuggets.setOnClickListener()
        {
            btnDecreaseNuggets.isEnabled = true

            //to increase the quantity order
            totalQuantityNuggets++

            //to calculate the charge
            txtQuantityNuggets.setText("Total Quantity: " + totalQuantityNuggets)
            totalChargeNuggets = totalQuantityNuggets * Nuggets
        }

        btnIncreaseSpicyChicken.setOnClickListener()
        {
            btnDecreaseSpicyChicken.isEnabled = true

            //to increase the quantity order
            totalQuantitySpicyChicken++

            //to calculate the charge
            txtQuantitySpicyChicken.setText("Total Quantity: " + totalQuantitySpicyChicken)
            totalChargeSpicyChicken = totalQuantitySpicyChicken * SpicyChicken
        }

        btnIncreaseTaxWrap.setOnClickListener()
        {
            btnDecreaseTaxWrap.isEnabled = true

            //to increase the quantity order
            totalQuantityTaxWrap++

            //to calculate the charge
            txtQuantityTaxWrap.setText("Total Quantity: " + totalQuantityTaxWrap)
            totalChargeTaxWrap = totalQuantityTaxWrap * TaxWrap
        }

        //Decrease Button
        btnDecreaseHoneyButterBisc.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityHoneyButterBisc--
            txtQuantityHoneyButterBisc.setText("Total Quantity: " + totalQuantityHoneyButterBisc)
            totalChargeHoneyButterBisc = totalQuantityHoneyButterBisc * HoneyButterBisc

            if(totalQuantityHoneyButterBisc <= 0)
            {
                btnDecreaseHoneyButterBisc.isEnabled = false
            }
        }

        btnDecreaseMexicanawrap.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityMexicanawrap--
            txtQuantityMexicanawrap.setText("Total Quantity: " + totalQuantityMexicanawrap)
            totalChargeMexicanawrap = totalQuantityMexicanawrap * Mexicanawrap

            if(totalQuantityMexicanawrap <= 0)
            {
                btnDecreaseMexicanawrap.isEnabled = false
            }
        }

        btnDecreaseNuggets.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityNuggets--
            txtQuantityNuggets.setText("Total Quantity: " + totalQuantityNuggets)
            totalChargeNuggets = totalQuantityNuggets * Nuggets

            if(totalQuantityNuggets <= 0)
            {
                btnDecreaseNuggets.isEnabled = false
            }
        }

        btnDecreaseSpicyChicken.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantitySpicyChicken--
            txtQuantitySpicyChicken.setText("Total Quantity: " + totalQuantitySpicyChicken)
            totalChargeSpicyChicken = totalQuantitySpicyChicken * SpicyChicken

            if(totalQuantitySpicyChicken <= 0)
            {
                btnDecreaseSpicyChicken.isEnabled = false
            }
        }

        btnDecreaseTaxWrap.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityTaxWrap--
            txtQuantityTaxWrap.setText("Total Quantity: " + totalQuantityTaxWrap)
            totalChargeTaxWrap = totalQuantityTaxWrap * TaxWrap

            if(totalQuantityTaxWrap <= 0)
            {
                btnDecreaseTaxWrap.isEnabled = false
            }
        }

        btnPlaceOrderTaxes.setOnClickListener()
        {
            //to disable all button -> increase and decrease
            //to disable button function -> if the quantity and amount is not null or 0.00
            if(totalChargeHoneyButterBisc != 0.00 || totalChargeMexicanawrap != 0.00 || totalChargeNuggets != 0.00 || totalChargeSpicyChicken != 0.00
                || totalChargeTaxWrap != 0.00)
            {
                btnDecreaseHoneyButterBisc.isEnabled = false
                btnDecreaseMexicanawrap.isEnabled = false
                btnDecreaseNuggets.isEnabled = false
                btnDecreaseSpicyChicken.isEnabled = false
                btnDecreaseTaxWrap.isEnabled = false

                btnIncreaseHoneyButterBisc.isEnabled = false
                btnIncreaseMexicanawrap.isEnabled = false
                btnIncreaseNuggets.isEnabled = false
                btnIncreaseSpicyChicken.isEnabled = false
                btnIncreaseTaxWrap.isEnabled = false

                btnPlaceOrderTaxes.isVisible = false
                btnConfirmOrderTaxes.isVisible = true
                btnReorderTaxes.isVisible = true

                //to calculate actual amount
                totalEstimateOrderQuantity = totalQuantityHoneyButterBisc + totalQuantityMexicanawrap + totalQuantityNuggets + totalQuantitySpicyChicken + totalQuantityTaxWrap
                totalEstimateCharge = totalChargeHoneyButterBisc + totalChargeMexicanawrap + totalChargeNuggets + totalChargeSpicyChicken + totalChargeTaxWrap

                txtTotalTaxesQuantity.text = totalEstimateOrderQuantity.toString()
                txtTotalTaxesEstimatePrice.text = totalEstimateCharge.toString()
            }

            else
            {
                Toast.makeText(applicationContext, "Please Place an Order First", Toast.LENGTH_LONG).show()
            }
        }

        btnReorderTaxes.setOnClickListener()
        {
            //to clear the estimate total quantity, total amount
            txtTotalTaxesQuantity.setText("")
            txtTotalTaxesEstimatePrice.setText("")

            //to check if the quantity for each menu has quantity
            //if have, enable the decrease button else cannot
            btnIncreaseHoneyButterBisc.isEnabled = true
            btnIncreaseMexicanawrap.isEnabled = true
            btnIncreaseNuggets.isEnabled = true
            btnIncreaseSpicyChicken.isEnabled = true
            btnIncreaseTaxWrap.isEnabled = true

            if(totalQuantityHoneyButterBisc != 0){
                btnDecreaseHoneyButterBisc.isEnabled = true
            }

            if(totalQuantityMexicanawrap != 0){
                btnDecreaseMexicanawrap.isEnabled = true
            }

            if(totalQuantityNuggets != 0){
                btnDecreaseNuggets.isEnabled = true
            }

            if(totalQuantitySpicyChicken != 0){
                btnDecreaseSpicyChicken.isEnabled = true
            }

            if(totalQuantityTaxWrap != 0){
                btnDecreaseTaxWrap.isEnabled = true
            }

            btnReorderTaxes.isVisible = false
            btnConfirmOrderTaxes.isVisible = false
            btnPlaceOrderTaxes.isVisible = true
        }

        btnConfirmOrderTaxes.setOnClickListener()
        {
            Go2Payment()
        }
    }


    fun Go2Payment()
    {
        var intent = Intent(this, PaymentOrder::class.java)

        intent.putExtra("TotalQty", txtTotalTaxesQuantity.text.toString())
        intent.putExtra("TotalEstPrice", txtTotalTaxesEstimatePrice.text.toString())
        intent.putExtra("UserEmail", userEmail)
        startActivity(intent)
    }
}
