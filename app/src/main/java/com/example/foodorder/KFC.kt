package com.example.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_kfc.*
import kotlinx.android.synthetic.main.activity_kfc.view.*

class KFC : AppCompatActivity() {

    //create variables
    var ExtraCrispy : Double = 45.00
    var ExtraCrispyTender : Double = 17.00
    var FamousBowl : Double = 15.00
    var TheOriginal : Double = 40.00

    //Total Quantity For Each Meal
    var totalQuantityExtraCrispy : Int = 0
    var totalQuantityExtraCrispyTender : Int = 0
    var totalQuantityFamousBowl : Int = 0
    var totalQuantityTheOriginal : Int = 0

    //Total Charge For Each Meal
    var totalChargeExtraCrispy : Double = 0.00
    var totalChargeExtraCrispyTender : Double = 0.00
    var totalChargeFamousBowl : Double = 0.00
    var totalChargeTheOriginal : Double = 0.00

    var totalEstimateCharge : Double = 0.00 // to hold estimate charge when user place an order
    var totalEstimateOrderQuantity : Int = 0 // to hold estimate quantity when user place an order
    var userEmail: String? = null // to hold user email

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kfc)

        //to disable button function
        btnDecreaseExtraCrispy.isEnabled = false
        btnDecreaseTheOriginal.isEnabled = false
        btnDecreaseExtraCrispyTender.isEnabled = false
        btnDecreaseFamousBowl.isEnabled = false

        btnConfirmOrderKFC.isVisible = false
        btnReorderKFC.isVisible = false

        txtQuantityExtraCrispy.setText("Total Quantity: " + totalQuantityExtraCrispy)
        txtQuantityExtraCrispyTender.setText("Total Quantity: " + totalQuantityExtraCrispyTender)
        txtQuantityFamousBowl.setText("Total Quantity: " + totalQuantityFamousBowl)
        txtQuantityTheOrigin.setText("Total Quantity: " + totalQuantityTheOriginal)

        //Increase button
        btnIncreaseExtraCrispy.setOnClickListener()
        {
            btnDecreaseExtraCrispy.isEnabled = true

            //to increase the quantity order
            totalQuantityExtraCrispy++

            //to calculate the charge
            txtQuantityExtraCrispy.setText("Total Quantity: " + totalQuantityExtraCrispy)
            totalChargeExtraCrispy = totalQuantityExtraCrispy * ExtraCrispy
        }

        btnIncreaseExtraCrispyTender.setOnClickListener()
        {
            btnDecreaseExtraCrispyTender.isEnabled = true

            //to increase the quantity order
            totalQuantityExtraCrispyTender++

            //to calculate the charge
            txtQuantityExtraCrispyTender.setText("Total Quantity: " + totalQuantityExtraCrispyTender)
            totalChargeExtraCrispyTender = totalQuantityExtraCrispyTender * ExtraCrispyTender
        }

        btnIncreaseFamousBowl.setOnClickListener()
        {
            btnDecreaseFamousBowl.isEnabled = true

            //to increase the quantity order
            totalQuantityFamousBowl++

            //to calculate the charge
            txtQuantityFamousBowl.setText("Total Quantity: " + totalQuantityFamousBowl)
            totalChargeFamousBowl = totalQuantityFamousBowl * FamousBowl
        }

        btnIncreaseTheOriginal.setOnClickListener()
        {
            btnDecreaseTheOriginal.isEnabled = true

            //to increase the quantity order
            totalQuantityTheOriginal++

            //to calculate the charge
            txtQuantityTheOrigin.setText("Total Quantity: " + totalQuantityTheOriginal)
            totalChargeTheOriginal = totalQuantityTheOriginal * TheOriginal
        }

        //Decrease button
        btnDecreaseExtraCrispy.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityExtraCrispy--
            txtQuantityExtraCrispy.setText("Total Quantity: " + totalQuantityExtraCrispy)
            totalChargeExtraCrispy = totalQuantityExtraCrispy * ExtraCrispy

            if(totalQuantityExtraCrispy <= 0)
            {
                btnDecreaseExtraCrispy.isEnabled = false
            }
        }

        btnDecreaseTheOriginal.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityTheOriginal--
            txtQuantityTheOrigin.setText("Total Quantity: " + totalQuantityTheOriginal)
            totalChargeTheOriginal = totalQuantityTheOriginal * TheOriginal

            if(totalQuantityTheOriginal <= 0)
            {
                btnDecreaseTheOriginal.isEnabled = false
            }
        }

        btnDecreaseExtraCrispyTender.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityExtraCrispyTender--
            txtQuantityExtraCrispyTender.setText("Total Quantity: " + totalQuantityExtraCrispyTender)
            totalChargeExtraCrispyTender = totalQuantityExtraCrispyTender * ExtraCrispyTender

            if(totalQuantityExtraCrispyTender <= 0)
            {
                btnDecreaseExtraCrispyTender.isEnabled = false
            }
        }

        btnDecreaseFamousBowl.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityFamousBowl--
            txtQuantityFamousBowl.setText("Total Quantity: " + totalQuantityFamousBowl)
            totalChargeFamousBowl = totalQuantityFamousBowl * FamousBowl

            if (totalQuantityFamousBowl <= 0) {
                btnDecreaseFamousBowl.isEnabled = false
            }
        }

        btnPlaceOrderKFC.setOnClickListener()
        {
            //to disable all button -> increase and decrease
            //to disable button function -> if the quantity amount is not null or 0.00
            if(totalChargeExtraCrispy != 0.00 || totalChargeExtraCrispyTender != 0.00 || totalChargeFamousBowl != 0.00 || totalChargeTheOriginal != 0.00)
            {
                btnDecreaseExtraCrispy.isEnabled = false
                btnDecreaseTheOriginal.isEnabled = false
                btnDecreaseExtraCrispyTender.isEnabled = false
                btnDecreaseFamousBowl.isEnabled = false

                btnIncreaseExtraCrispy.isEnabled = false
                btnIncreaseTheOriginal.isEnabled = false
                btnIncreaseExtraCrispyTender.isEnabled = false
                btnIncreaseFamousBowl.isEnabled = false

                btnPlaceOrderKFC.isVisible = false
                btnConfirmOrderKFC.isVisible = true
                btnReorderKFC.isVisible = true

                //to calculate actual amount
                totalEstimateOrderQuantity = totalQuantityExtraCrispy + totalQuantityExtraCrispyTender + totalQuantityFamousBowl + totalQuantityTheOriginal
                totalEstimateCharge = totalChargeExtraCrispy + totalChargeExtraCrispyTender + totalChargeFamousBowl + totalChargeTheOriginal

                txtTotalKFCQuantity.text = totalEstimateOrderQuantity.toString()
                txtTotalKFCEstimatePrice.text = totalEstimateCharge.toString()
            }

            else
            {
                Toast.makeText(applicationContext, "Please Place an Order First", Toast.LENGTH_LONG).show()
            }
        }

        btnReorderKFC.setOnClickListener()
        {
            //to clear the estimate total quantity, total amount
            txtTotalKFCQuantity.setText("")
            txtTotalKFCEstimatePrice.setText("")

            //to check if the quantity for each menu has quantity
            //if have, enable the decrease button, else cannot
            btnIncreaseExtraCrispy.isEnabled = true
            btnIncreaseTheOriginal.isEnabled = true
            btnIncreaseExtraCrispyTender.isEnabled = true
            btnIncreaseFamousBowl.isEnabled = true

            if(totalQuantityExtraCrispy != 0){
                btnDecreaseExtraCrispy.isEnabled = true
            }

            if(totalQuantityTheOriginal != 0){
                btnDecreaseTheOriginal.isEnabled = true
            }

            if(totalQuantityExtraCrispyTender != 0){
                btnDecreaseExtraCrispyTender.isEnabled = true
            }

            if(totalQuantityFamousBowl != 0){
                btnDecreaseFamousBowl.isEnabled = true
            }

            btnReorderKFC.isVisible = false
            btnConfirmOrderKFC.isVisible = false
            btnPlaceOrderKFC.isVisible = true
        }

        btnConfirmOrderKFC.setOnClickListener()
        {
            Go2Payment()
        }
    }

    fun Go2Payment(){
        var intent = Intent(this, PaymentOrder::class.java)

        intent.putExtra("TotalQty", txtTotalKFCQuantity.text.toString())
        intent.putExtra("TotalEstPrice", txtTotalKFCEstimatePrice.text.toString())
        intent.putExtra("UserEmail", userEmail)
        startActivity(intent)

    }


}
