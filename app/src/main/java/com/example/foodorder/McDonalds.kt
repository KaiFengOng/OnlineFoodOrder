package com.example.foodorder

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mc_donalds.*

class McDonalds : AppCompatActivity() {

    //Create Variables
    var BaconBBQBurger : Double = 17.00
    var DoubleBaconBBQBurger : Double = 20.00
    var McChicken : Double = 12.00
    var FiletOFish : Double = 15.00
    var Porridge : Double = 10.00

    //Total Quantity For Each Meal
    var totalQuantityBaconBBQBurger : Int = 0
    var totalQuantityDoubleBaconBBQBurger : Int = 0
    var totalQuantityMcChicken : Int = 0
    var totalQuantityFiletOFish : Int = 0
    var totalQuantityPorridge : Int = 0

    //Total Each details of total set order price
    var totalChargeBaconBBQBurger : Double = 0.0
    var totalChargeDoubleBaconBBQBurger : Double = 0.0
    var totalChargeMcChicken : Double = 0.0
    var totalChargeFiletOFish : Double = 0.0
    var totalChargePorridge : Double = 0.0

    var totalEstimateCharge : Double = 0.00 // to hold estimate amount charge when user place order ( Price )
    var totalEstimateOrderQuantity : Int = 0 // to hold estimate amount quantity when user palce order ( Quantity )
    var userEmail: String? = null // to hold user email

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mc_donalds)

        //To disable button function
        btnDecreaseBaconBBQBurger.isEnabled = false
        btnDecreaseDoubleBaconBBQBurger.isEnabled = false
        btnDecreaseMcChicken.isEnabled = false
        btnDecreaseFiletOFish.isEnabled = false
        btnDecreasePorridge.isEnabled = false

        btnConfirmOrderMcDonald.isVisible = false
        btnReorderMcDonald.isVisible =false

        txtQuantityBaconBBQBurger.setText("Total Quantity: " + totalQuantityBaconBBQBurger)
        txtQuantityDoubleBaconBBQBurger.setText("Total Quantity: " + totalQuantityDoubleBaconBBQBurger)
        txtQuantityMcChicken.setText("Total Quantity: " + totalQuantityMcChicken)
        txtQuantityFiletOFish.setText("Total Quantity: " + totalQuantityFiletOFish)
        txtQuantityPorridge.setText("Total Quantity: " + totalQuantityPorridge)

        //Increase button
        btnIncreaseBaconBBQBurger.setOnClickListener()
        {
            btnDecreaseBaconBBQBurger.isEnabled  = true

            //to increase the quantity order
            totalQuantityBaconBBQBurger++

            //to calculate the charge
            txtQuantityBaconBBQBurger.setText("Total Quantity: " + totalQuantityBaconBBQBurger)
            totalChargeBaconBBQBurger = totalQuantityBaconBBQBurger * BaconBBQBurger
        }

        btnIncreaseDoubleBaconBBQBurger.setOnClickListener()
        {
            btnDecreaseDoubleBaconBBQBurger.isEnabled = true

            //to increase the quantity order
            totalQuantityDoubleBaconBBQBurger++

            //to calculate the charge
            txtQuantityDoubleBaconBBQBurger.setText("Total Quantity: " + totalQuantityDoubleBaconBBQBurger)
            totalChargeDoubleBaconBBQBurger = totalQuantityDoubleBaconBBQBurger * DoubleBaconBBQBurger
        }

        btnIncreaseMcChicken.setOnClickListener()
        {
            btnDecreaseMcChicken.isEnabled = true

            //to increase the quantity order
            totalQuantityMcChicken++

            //to calculate the charge
            txtQuantityMcChicken.setText("Total Quantity: " + totalQuantityMcChicken)
            totalChargeMcChicken = totalQuantityMcChicken * McChicken
        }

        btnIncreaseFiletOFish.setOnClickListener()
        {

            btnDecreaseFiletOFish.isEnabled = true

            //to increase the quantity order
            totalQuantityFiletOFish++

            //to calculate the charge
            txtQuantityFiletOFish.setText("Total Quantity: " + totalQuantityFiletOFish)
            totalChargeFiletOFish = totalQuantityFiletOFish * FiletOFish
        }

        btnIncreasePorridge.setOnClickListener()
        {
            btnDecreasePorridge.isEnabled = true

            //to increase the quantity order
            totalQuantityPorridge++

            //to calculate the charge
            txtQuantityPorridge.setText("Total Quantity: " + totalQuantityPorridge)
            totalChargePorridge = totalQuantityPorridge * Porridge
        }


        //Decrease button
        btnDecreaseBaconBBQBurger.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityBaconBBQBurger--
            txtQuantityBaconBBQBurger.setText("Total Quantity: " + totalQuantityBaconBBQBurger)
            totalChargeBaconBBQBurger = totalQuantityBaconBBQBurger * BaconBBQBurger

            if(totalQuantityBaconBBQBurger <= 0)
            {
                btnDecreaseBaconBBQBurger.isEnabled = false
            }
        }

        btnDecreaseDoubleBaconBBQBurger.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityDoubleBaconBBQBurger--
            txtQuantityDoubleBaconBBQBurger.setText("Total Quantity: " + totalQuantityDoubleBaconBBQBurger)
            totalChargeDoubleBaconBBQBurger = totalQuantityDoubleBaconBBQBurger * DoubleBaconBBQBurger

            if(totalQuantityDoubleBaconBBQBurger <= 0)
            {
                btnDecreaseDoubleBaconBBQBurger.isEnabled = false
            }
        }

        btnDecreaseMcChicken.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityMcChicken--
            txtQuantityMcChicken.setText("Total Quantity: " + totalQuantityMcChicken)
            totalChargeMcChicken = totalQuantityMcChicken * McChicken

            if(totalQuantityMcChicken <= 0)
            {
                btnDecreaseMcChicken.isEnabled = false
            }
        }

        btnDecreaseFiletOFish.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityFiletOFish--
            txtQuantityFiletOFish.setText("Total Quantity: " + totalQuantityFiletOFish)
            totalChargeFiletOFish = totalQuantityFiletOFish * FiletOFish

            if(totalQuantityFiletOFish <= 0)
            {
                btnDecreaseFiletOFish.isEnabled = false
            }
        }

        btnDecreasePorridge.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityPorridge--
            txtQuantityPorridge.setText("Total Quantity: " + totalQuantityPorridge)
            totalChargePorridge = totalQuantityPorridge * Porridge

            if(totalQuantityPorridge <= 0 )
            {
                btnDecreasePorridge.isEnabled = false
            }
        }


        //To Perform Order Function
        btnPlaceOrderMcDonald.setOnClickListener()
        {
            //to disable all button -> increase and decrease button
            //To disable button function -> if the quantity and amount is not null or 0.00
            if(totalChargeBaconBBQBurger != 0.00 || totalChargeDoubleBaconBBQBurger != 0.00 || totalChargeMcChicken != 0.00 || totalChargeFiletOFish != 0.00 || totalChargePorridge != 0.00) {
                btnDecreaseBaconBBQBurger.isEnabled = false
                btnDecreaseDoubleBaconBBQBurger.isEnabled = false
                btnDecreaseMcChicken.isEnabled = false
                btnDecreaseFiletOFish.isEnabled = false
                btnDecreasePorridge.isEnabled = false

                btnIncreaseBaconBBQBurger.isEnabled = false
                btnIncreaseDoubleBaconBBQBurger.isEnabled = false
                btnIncreaseMcChicken.isEnabled = false
                btnIncreaseFiletOFish.isEnabled = false
                btnIncreasePorridge.isEnabled = false

                btnPlaceOrderMcDonald.isVisible = false
                btnConfirmOrderMcDonald.isVisible = true
                btnReorderMcDonald.isVisible = true

                //to calculate actual amount
                totalEstimateOrderQuantity =
                    totalQuantityBaconBBQBurger + totalQuantityDoubleBaconBBQBurger + totalQuantityFiletOFish + totalQuantityMcChicken + totalQuantityPorridge
                totalEstimateCharge =
                    totalChargeBaconBBQBurger + totalChargeDoubleBaconBBQBurger + totalChargeFiletOFish + totalChargeMcChicken + totalChargePorridge

                txtTotalMcDonaldQuantity.text = totalEstimateOrderQuantity.toString()
                txtTotalMcDonaldEstimatePrice.text = totalEstimateCharge.toString() + "0"
            }

            else
            {
                Toast.makeText(applicationContext, "Please Place an Order First", Toast.LENGTH_LONG).show()
            }
        }

        btnReorderMcDonald.setOnClickListener()
        {
            //to clear the estimate total quantity, total amount
            txtTotalMcDonaldQuantity.setText("")
            txtTotalMcDonaldEstimatePrice.setText("")

            //to check if the quantity for each menu has quantity
            //if have, enable the decrease button else cannot
            btnIncreaseBaconBBQBurger.isEnabled = true
            btnIncreaseDoubleBaconBBQBurger.isEnabled = true
            btnIncreaseMcChicken.isEnabled = true
            btnIncreaseFiletOFish.isEnabled = true
            btnIncreasePorridge.isEnabled = true

            if(totalQuantityBaconBBQBurger != 0){
                btnDecreaseBaconBBQBurger.isEnabled = true
            }

            if(totalQuantityDoubleBaconBBQBurger != 0){
                btnDecreaseDoubleBaconBBQBurger.isEnabled = true
            }

            if(totalQuantityMcChicken != 0){
                btnDecreaseMcChicken.isEnabled = true
            }

            if(totalQuantityFiletOFish != 0){
                btnDecreaseFiletOFish.isEnabled = true
            }

            if(totalQuantityPorridge != 0){
                btnDecreasePorridge.isEnabled = true
            }

            btnReorderMcDonald.isVisible = false
            btnPlaceOrderMcDonald.isVisible = true
            btnConfirmOrderMcDonald.isVisible = false
        }

        btnConfirmOrderMcDonald.setOnClickListener()
        {
            Go2Payment()
        }
    }

    fun Go2Payment(){
        var intent = Intent(this, PaymentOrder::class.java)

        intent.putExtra("TotalQty", txtTotalMcDonaldQuantity.text.toString())
        intent.putExtra("TotalEstPrice", txtTotalMcDonaldEstimatePrice.text.toString())
        intent.putExtra("UserEmail", userEmail)
        startActivity(intent)
    }
}
