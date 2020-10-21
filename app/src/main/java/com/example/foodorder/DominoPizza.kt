package com.example.foodorder

import android.app.PendingIntent.getActivity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_domino_pizza.*
import kotlinx.android.synthetic.main.activity_main.*

class DominoPizza : AppCompatActivity() {

    //variables
    var ChickenConfidential : Double = 30.00
    var MeataSaurus : Double = 30.00
    var PrawnPassion : Double = 30.00
    var SimplyCheese : Double = 25.00
    var UltimateHawaiian : Double = 28.00
    var SmokyBeefandChick : Double = 40.00

    //Total Quantity For Each Meal
    var totalQuantityChickenConfidential : Int = 0
    var totalQuantityMeataSaurus : Int = 0
    var totalQuantityPrawnPassion : Int = 0
    var totalQuantitySimplyCheese : Int = 0
    var totalQuantityUltimateHawaiian : Int = 0
    var totalQuantitySmokyBeefandChick : Int = 0

    //Total Each Details of Total set order price
    var totalChargeChickenConfidential : Double = 0.0
    var totalChargeMeataSaurus : Double = 0.0
    var totalChargePrawnPassion : Double = 0.0
    var totalChargeSimplyCheese : Double = 0.0
    var totalChargeUltimateHawaiian : Double = 0.0
    var totalChargeSmokybeefandchick : Double = 0.0

    var totalEstimateCharge : Double = 0.00 // to hold estimate amount charge when user place order ( Price )
    var totalEstimateOrderQuantity : Int = 0 // to hold estimate amount quantity when user place order ( Quantity )
    var userEmail: String? = null //to hold user email


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_domino_pizza)
        userEmail = this.intent.getStringExtra("UserEmail")

        //To disable button
        btnDecreaseSimplyCheese.isEnabled = false
        btnDecreaseMeatSaurus.isEnabled = false
        btnDecreasePrawnPassion.isEnabled = false
        btnDecreaseUltimateHawaiian.isEnabled = false
        btnDecreaseChickenConfidential.isEnabled = false
        btnDecreaseSmokybeefandchick.isEnabled = false

        btnConfirmOrderDominoPizza.isVisible = false
        btnReorderDominoPizza.isVisible = false

        txtQuantitySimplyCheese.setText("Total Quantity: " + totalQuantitySimplyCheese)
        txtQuantityMeatSaurus.setText("Total Quantity: " + totalQuantityMeataSaurus)
        txtQuantityPrawnPassion.setText("Total Quantity: " + totalQuantityPrawnPassion)
        txtQuantityUltimateHawaiian.setText("Total Quantity: " + totalQuantityUltimateHawaiian)
        txtQuantityChickenConfidential.setText("Total Quantity: " + totalQuantityChickenConfidential)
        txtQuantitySmokybeefandchick.setText("Total Quantity: " + totalQuantitySmokyBeefandChick)

        //Increase button
        btnIncreaseSimplyCheese.setOnClickListener()
        {
            btnDecreaseSimplyCheese.isEnabled = true

            //to increase the quantity order
            totalQuantitySimplyCheese++

            //to calculate the charge
            txtQuantitySimplyCheese.setText("Total Quantity: " + totalQuantitySimplyCheese)
            totalChargeSimplyCheese = totalQuantitySimplyCheese * SimplyCheese
        }

        btnIncreaseMeatSaurus.setOnClickListener()
        {
            btnDecreaseMeatSaurus.isEnabled = true

            //to increase the quantity order
            totalQuantityMeataSaurus++

            //to calculate the charge
            txtQuantityMeatSaurus.setText("Total Quantity: " + totalQuantityMeataSaurus)
            totalChargeMeataSaurus = totalQuantityMeataSaurus * MeataSaurus
        }

        btnIncreasePrawnPassion.setOnClickListener()
        {
            btnDecreasePrawnPassion.isEnabled = true

            //to increase the quantity order
            totalQuantityPrawnPassion++

            //to calculate the charge
            txtQuantityPrawnPassion.setText("Total Quantity: " + totalQuantityPrawnPassion)
            totalChargePrawnPassion = totalQuantityPrawnPassion * PrawnPassion
        }

        btnIncreaseUltimateHawaiian.setOnClickListener()
        {
            btnDecreaseUltimateHawaiian.isEnabled = true

            //to increase the quantity order
            totalQuantityUltimateHawaiian++

            //to calculate the charge
            txtQuantityUltimateHawaiian.setText("Total Quantity: " + totalQuantityUltimateHawaiian)
            totalChargeUltimateHawaiian = totalQuantityUltimateHawaiian * UltimateHawaiian
        }

        btnIncreaseChickenConfidential.setOnClickListener()
        {
            btnDecreaseChickenConfidential.isEnabled = true

            //to increase the quantity order
            totalQuantityChickenConfidential++

            //to calculate the charge
            txtQuantityChickenConfidential.setText("Total Quantity: " + totalQuantityChickenConfidential)
            totalChargeChickenConfidential = totalQuantityChickenConfidential * ChickenConfidential
        }

        btnIncreaseSmokybeefandchick.setOnClickListener()
        {
            btnDecreaseSmokybeefandchick.isEnabled = true

            //to increase the quantity order
            totalQuantitySmokyBeefandChick++

            //to calculate the charge
            txtQuantitySmokybeefandchick.setText("Total Quantity: " + totalQuantitySmokyBeefandChick)
            totalChargeSmokybeefandchick = totalQuantitySmokyBeefandChick * SmokyBeefandChick
        }

        //Decrease button
        btnDecreaseSimplyCheese.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantitySimplyCheese--
            txtQuantitySimplyCheese.setText("Total Quantity: " + totalQuantitySimplyCheese)
            totalChargeSimplyCheese = totalQuantitySimplyCheese * SimplyCheese

            if(totalQuantitySimplyCheese <= 0)
            {
                btnDecreaseSimplyCheese.isEnabled = false
            }
        }

        btnDecreaseMeatSaurus.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityMeataSaurus--
            txtQuantityMeatSaurus.setText("Total Quantity: " + totalQuantityMeataSaurus)
            totalChargeMeataSaurus = totalQuantityMeataSaurus * MeataSaurus

            if(totalQuantityMeataSaurus <= 0)
            {
                btnDecreaseMeatSaurus.isEnabled = false
            }
        }

        btnDecreasePrawnPassion.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityPrawnPassion--
            txtQuantityPrawnPassion.setText("Total Quantity: " + totalQuantityPrawnPassion)
            totalChargePrawnPassion = totalQuantityPrawnPassion * PrawnPassion

            if(totalQuantityPrawnPassion <= 0)
            {
                btnDecreasePrawnPassion.isEnabled = false
            }
        }

        btnDecreaseUltimateHawaiian.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityUltimateHawaiian--
            txtQuantityUltimateHawaiian.setText("Total Quantity: " + totalQuantityUltimateHawaiian)
            totalChargeUltimateHawaiian = totalQuantityUltimateHawaiian * UltimateHawaiian

            if(totalQuantityUltimateHawaiian <= 0)
            {
                btnDecreaseUltimateHawaiian.isEnabled = false
            }
        }

        btnDecreaseChickenConfidential.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityChickenConfidential--
            txtQuantityChickenConfidential.setText("Total Quantity: " + totalQuantityChickenConfidential)
            totalChargeChickenConfidential = totalQuantityChickenConfidential * ChickenConfidential

            if(totalQuantityChickenConfidential <= 0)
            {
                btnDecreaseChickenConfidential.isEnabled = false
            }
        }

        btnDecreaseSmokybeefandchick.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantitySmokyBeefandChick--
            txtQuantitySmokybeefandchick.setText("Total Quantity: " + totalQuantitySmokyBeefandChick)
            totalChargeSmokybeefandchick = totalQuantitySmokyBeefandChick * SmokyBeefandChick

            if(totalQuantitySmokyBeefandChick <= 0)
            {
                btnDecreaseSmokybeefandchick.isEnabled = false
            }
        }

        btnPlaceOrderDominoPizza.setOnClickListener()
        {
            //To disable button function -> if quantity and amount is not null or 0.00
            if(totalChargeChickenConfidential != 0.00 ||  totalChargeMeataSaurus != 0.00 || totalChargePrawnPassion != 0.00 || totalChargeSimplyCheese != 0.00 ||
                    totalChargeUltimateHawaiian != 0.00 || totalChargeSmokybeefandchick != 0.00)
            {
                btnDecreaseChickenConfidential.isEnabled = false
                btnDecreaseMeatSaurus.isEnabled = false
                btnDecreaseSimplyCheese.isEnabled = false
                btnDecreaseMeatSaurus.isEnabled = false
                btnDecreasePrawnPassion.isEnabled = false
                btnDecreaseUltimateHawaiian.isEnabled = false
                btnDecreaseChickenConfidential.isEnabled = false
                btnDecreaseSmokybeefandchick.isEnabled = false

                btnIncreaseChickenConfidential.isEnabled = false
                btnIncreaseMeatSaurus.isEnabled = false
                btnIncreaseSimplyCheese.isEnabled = false
                btnIncreaseMeatSaurus.isEnabled = false
                btnIncreasePrawnPassion.isEnabled = false
                btnIncreaseUltimateHawaiian.isEnabled = false
                btnIncreaseChickenConfidential.isEnabled = false
                btnIncreaseSmokybeefandchick.isEnabled = false

                btnPlaceOrderDominoPizza.isVisible = false
                btnConfirmOrderDominoPizza.isVisible = true
                btnReorderDominoPizza.isVisible = true

                //to calculate amount
                totalEstimateOrderQuantity = totalQuantitySimplyCheese + totalQuantityMeataSaurus + totalQuantityPrawnPassion + totalQuantityUltimateHawaiian +
                        totalQuantityChickenConfidential + totalQuantitySmokyBeefandChick

                totalEstimateCharge = totalChargeSimplyCheese + totalChargeMeataSaurus + totalChargePrawnPassion + totalChargeUltimateHawaiian +
                        totalChargeChickenConfidential + totalChargeSmokybeefandchick

                txtTotalDominoQuantity.text = totalEstimateOrderQuantity.toString()
                txtTotalDominoEstimatePrice.text = totalEstimateCharge.toString() + "0"
            }

            else
            {
                Toast.makeText(applicationContext, "Please Place an Order First", Toast.LENGTH_LONG).show()
            }
        }

        btnReorderDominoPizza.setOnClickListener()
        {
            //to clear the estimate total quantity, total amount
            txtTotalDominoQuantity.setText("")
            txtTotalDominoEstimatePrice.setText("")

            //to check if the quantity for each menu has quantity
            //if have, enable the decrease button else cannot
            btnIncreaseSimplyCheese.isEnabled = true
            btnIncreaseMeatSaurus.isEnabled = true
            btnIncreasePrawnPassion.isEnabled = true
            btnIncreaseUltimateHawaiian.isEnabled = true
            btnIncreaseChickenConfidential.isEnabled = true
            btnIncreaseSmokybeefandchick.isEnabled = true

            if(totalQuantitySimplyCheese != 0){
                btnDecreaseSimplyCheese.isEnabled = true
            }

            if(totalQuantityMeataSaurus != 0){
                btnDecreaseMeatSaurus.isEnabled = true
            }

            if(totalQuantityPrawnPassion != 0){
                btnDecreasePrawnPassion.isEnabled = true
            }

            if(totalQuantityUltimateHawaiian != 0){
                btnDecreaseUltimateHawaiian.isEnabled = true
            }

            if(totalQuantityChickenConfidential != 0){
                btnDecreaseChickenConfidential.isEnabled = true
            }

            if(totalQuantitySmokyBeefandChick != 0){
                btnDecreaseSmokybeefandchick.isEnabled = true
            }

            btnReorderDominoPizza.isVisible = false
            btnPlaceOrderDominoPizza.isVisible = true
            btnConfirmOrderDominoPizza.isVisible = false
        }

        btnConfirmOrderDominoPizza.setOnClickListener()
        {
            Go2Payment()
        }
    }

    fun Go2Payment(){
        var intent = Intent(this, PaymentOrder::class.java)
        intent.putExtra("TotalQty", txtTotalDominoQuantity.text.toString())
        intent.putExtra("TotalEstPrice", txtTotalDominoEstimatePrice.text.toString())
        intent.putExtra("UserEmail", userEmail)
        startActivity(intent)
    }
}
