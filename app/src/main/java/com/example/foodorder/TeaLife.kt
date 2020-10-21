package com.example.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_tea_life.*

class TeaLife : AppCompatActivity() {

    //create variable
    var MilkTeaWthGrassJelly : Double = 15.00
    var HazelnutMilkTea : Double = 15.00
    var MilkTeaHorlicks : Double = 17.00
    var OrgPearlMilkTea : Double = 13.00
    var RedBeanPearMilkTea : Double = 17.00
    var SigBrownSugarPearlMilkTea : Double = 18.00

    //Total Quantity For Each Meal
    var totalQuantityMilkTeaWthGrassJelly : Int = 0
    var totalQuantityHazelnut : Int = 0
    var totalQuantityMilkTeaHorlicks : Int = 0
    var totalQuantityOrgPearlMilkTea : Int = 0
    var totalQuantityRedBeanPear : Int = 0
    var totalQuantitySigBrownSugarPearl : Int = 0

    //Total Price For Each Meal
    var totalChargeMilkTeaWthGrassJelly : Double = 0.00
    var totalChargeHazelnut : Double = 0.00
    var totalChargeMilkTeaHorlicks : Double = 0.00
    var totalChargeOrgPearlMilkTea : Double = 0.00
    var totalChargeRedBeanPear : Double = 0.00
    var totalChargeSigBrownSugarPearl : Double = 0.00

    var totalEstimateCharge : Double = 0.00 // to hold estimate amount charge when user place order (price)
    var totalEstimateOrderQuantity : Int = 0 //to hold estimate amount quantity when user place order (quantity)
    var userEmail: String? = null // to hold user email


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tea_life)

        //To disable every decrease button
        btnDecreaseMilkTeaGrassJelly.isEnabled = false
        btnDecreaseHazelNutMilkTea.isEnabled = false
        btnDecreaseMilkTeaHorlicks.isEnabled = false
        btnDecreaseOrgPearlMilkTea.isEnabled = false
        btnDecreaseRedBeanPearl.isEnabled = false
        btnDecreaseSigBrownSugar.isEnabled = false

        btnConfirmOrderTeaLife.isVisible = false
        btnReorderTeaLife.isVisible = false

        txtQuantityMilkTeaGrassJelly.setText("Total Quantity: " + totalQuantityMilkTeaWthGrassJelly)
        txtQuantityHazelNutMilkTea.setText("Total Quanitity: " + totalQuantityHazelnut)
        txtQuantityMilkTeaHorlicks.setText("Total Quantity: " + totalQuantityMilkTeaHorlicks)
        txtQuantityOrgPearlMilkTea.setText("Total Quantity: " + totalQuantityOrgPearlMilkTea)
        txtQuantityRedBeanPearl.setText("Total Quantity: " + totalQuantityRedBeanPear)
        txtQuantitySigBrownSugar.setText("Total QUantity: " + totalQuantitySigBrownSugarPearl)

        //Increase Button
        btnIncreaseMilkTeaGrassJelly.setOnClickListener()
        {
            btnDecreaseMilkTeaGrassJelly.isEnabled = true

            //to increase the quantity order
            totalQuantityMilkTeaWthGrassJelly++

            //to cal the charge
            txtQuantityMilkTeaGrassJelly.setText("Total Qunatity: " + totalQuantityMilkTeaWthGrassJelly)
            totalChargeMilkTeaWthGrassJelly = totalQuantityMilkTeaWthGrassJelly * MilkTeaWthGrassJelly
        }

        btnIncreaseHazelNutMilkTea.setOnClickListener()
        {
            btnDecreaseHazelNutMilkTea.isEnabled = true

            //to increase the quantity order
            totalQuantityHazelnut++

            //to cal the charge
            txtQuantityHazelNutMilkTea.setText("Total Quantity: " + totalQuantityHazelnut)
            totalChargeHazelnut = totalQuantityHazelnut * HazelnutMilkTea
        }

        btnIncreaseMilkTeaHorlicks.setOnClickListener()
        {
            btnDecreaseMilkTeaHorlicks.isEnabled = true

            //to increase the quantity order
            totalQuantityMilkTeaHorlicks++

            //to cal the charge
            txtQuantityMilkTeaHorlicks.setText("Total Quantity: " + totalQuantityMilkTeaHorlicks)
            totalChargeMilkTeaHorlicks = totalQuantityMilkTeaHorlicks * MilkTeaHorlicks
        }

        btnIncreaseOrgPearlMilkTea.setOnClickListener()
        {
            btnDecreaseOrgPearlMilkTea.isEnabled = true

            //to increase the quantity order
            totalQuantityOrgPearlMilkTea++

            //to cal the charge
            txtQuantityOrgPearlMilkTea.setText("Total Quantity: " + totalQuantityOrgPearlMilkTea)
            totalChargeOrgPearlMilkTea = totalQuantityOrgPearlMilkTea * OrgPearlMilkTea
        }

        btnIncreaseRedBeanPearl.setOnClickListener()
        {
            btnDecreaseRedBeanPearl.isEnabled = true

            //to increase the quantity order
            totalQuantityRedBeanPear++

            //to cal the charge
            txtQuantityRedBeanPearl.setText("Total Quantity: " + totalQuantityRedBeanPear)
            totalChargeRedBeanPear = totalQuantityRedBeanPear * RedBeanPearMilkTea
        }

        btnIncreaseSigBrownSugar.setOnClickListener()
        {
            btnDecreaseSigBrownSugar.isEnabled = true

            //to increase the quantity order
            totalQuantitySigBrownSugarPearl++

            //to cal the charge
            txtQuantitySigBrownSugar.setText("Total Quantity: " + totalQuantitySigBrownSugarPearl)
            totalChargeSigBrownSugarPearl = totalQuantitySigBrownSugarPearl * SigBrownSugarPearlMilkTea
        }

        //Decrease Button
        btnDecreaseMilkTeaGrassJelly.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityMilkTeaWthGrassJelly--
            txtQuantityMilkTeaGrassJelly.setText("Total Quantity: " + totalQuantityMilkTeaWthGrassJelly)
            totalChargeMilkTeaWthGrassJelly = totalQuantityMilkTeaWthGrassJelly * MilkTeaWthGrassJelly

            if(totalChargeMilkTeaWthGrassJelly <= 0)
            {
                btnDecreaseMilkTeaGrassJelly.isEnabled = false
            }
        }

        btnDecreaseHazelNutMilkTea.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityHazelnut--
            txtQuantityHazelNutMilkTea.setText("Total Quantity: " + totalQuantityHazelnut)
            totalChargeHazelnut = totalQuantityHazelnut * HazelnutMilkTea

            if(totalChargeHazelnut <= 0 )
            {
                btnDecreaseHazelNutMilkTea.isEnabled = false
            }
        }

        btnDecreaseMilkTeaHorlicks.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityMilkTeaHorlicks--
            txtQuantityMilkTeaHorlicks.setText("Total Quantity: " + totalQuantityMilkTeaHorlicks)
            totalChargeMilkTeaHorlicks = totalQuantityMilkTeaHorlicks * MilkTeaHorlicks

            if(totalChargeMilkTeaHorlicks <= 0)
            {
                btnDecreaseMilkTeaHorlicks.isEnabled = false
            }
        }

        btnDecreaseOrgPearlMilkTea.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityOrgPearlMilkTea--
            txtQuantityOrgPearlMilkTea.setText("Total Quantity: " + totalQuantityOrgPearlMilkTea)
            totalChargeOrgPearlMilkTea = totalQuantityOrgPearlMilkTea * OrgPearlMilkTea

            if(totalChargeOrgPearlMilkTea <= 0)
            {
                btnDecreaseOrgPearlMilkTea.isEnabled = false
            }
        }

        btnDecreaseRedBeanPearl.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantityRedBeanPear--
            txtQuantityRedBeanPearl.setText("Total Quantity: " + totalQuantityRedBeanPear)
            totalChargeRedBeanPear = totalQuantityRedBeanPear * RedBeanPearMilkTea

            if(totalChargeRedBeanPear <= 0)
            {
                btnDecreaseRedBeanPearl.isEnabled = false
            }
        }

        btnDecreaseSigBrownSugar.setOnClickListener()
        {
            //to delete the order quantity
            totalQuantitySigBrownSugarPearl--
            txtQuantitySigBrownSugar.setText("Total Quantity: " + totalQuantitySigBrownSugarPearl)
            totalChargeSigBrownSugarPearl = totalQuantitySigBrownSugarPearl * SigBrownSugarPearlMilkTea

            if(totalChargeSigBrownSugarPearl <= 0)
            {
                btnDecreaseSigBrownSugar.isEnabled = false
            }
        }

        btnPlaceOrderTeaLife.setOnClickListener()
        {
            //to disable all button -> increase and decrease
            //to disable button function -> if the quantity and amount is not nullor 0.00
            if(totalChargeMilkTeaWthGrassJelly != 0.00 || totalChargeHazelnut != 0.00 || totalChargeMilkTeaHorlicks != 0.00 || totalChargeOrgPearlMilkTea != 0.00
                || totalChargeRedBeanPear != 0.00 || totalChargeSigBrownSugarPearl != 0.00)
            {
                btnDecreaseMilkTeaGrassJelly.isEnabled = false
                btnDecreaseHazelNutMilkTea.isEnabled = false
                btnDecreaseMilkTeaHorlicks.isEnabled = false
                btnDecreaseOrgPearlMilkTea.isEnabled = false
                btnDecreaseRedBeanPearl.isEnabled = false
                btnDecreaseSigBrownSugar.isEnabled = false

                btnIncreaseMilkTeaGrassJelly.isEnabled = false
                btnIncreaseHazelNutMilkTea.isEnabled = false
                btnIncreaseMilkTeaHorlicks.isEnabled = false
                btnIncreaseOrgPearlMilkTea.isEnabled = false
                btnIncreaseRedBeanPearl.isEnabled = false
                btnIncreaseSigBrownSugar.isEnabled = false

                btnPlaceOrderTeaLife.isVisible = false
                btnConfirmOrderTeaLife.isVisible = true
                btnReorderTeaLife.isVisible = true

                //to calculate actual amount
                totalEstimateOrderQuantity = totalQuantityMilkTeaWthGrassJelly + totalQuantityHazelnut + totalQuantityMilkTeaHorlicks + totalQuantityOrgPearlMilkTea +
                        totalQuantityRedBeanPear + totalQuantitySigBrownSugarPearl
                totalEstimateCharge = totalChargeMilkTeaWthGrassJelly + totalChargeHazelnut + totalChargeMilkTeaHorlicks + totalChargeOrgPearlMilkTea + totalChargeRedBeanPear +
                        totalChargeSigBrownSugarPearl

                txtTotalTeaLifeQuantity.text = totalEstimateOrderQuantity.toString()
                txtTotalTeaLifeEstimatePrice.text = totalEstimateCharge.toString()


            }

            else
            {
                Toast.makeText(applicationContext, "Please Place an Order First", Toast.LENGTH_LONG).show()
            }
        }

        btnReorderTeaLife.setOnClickListener()
        {
            //to clear the estimate total quantity, total amount
            txtTotalTeaLifeQuantity.setText("")
            txtTotalTeaLifeEstimatePrice.setText("")

            //to check if the quantity for each menu has quantity
            //if have, enable the decrease button else cannot
            btnIncreaseMilkTeaGrassJelly.isEnabled = true
            btnIncreaseHazelNutMilkTea.isEnabled = true
            btnIncreaseMilkTeaHorlicks.isEnabled = true
            btnIncreaseOrgPearlMilkTea.isEnabled = true
            btnIncreaseRedBeanPearl.isEnabled = true
            btnIncreaseSigBrownSugar.isEnabled = true

            if(totalQuantityMilkTeaWthGrassJelly != 0){
                btnDecreaseMilkTeaGrassJelly.isEnabled = true
            }

            if(totalQuantityHazelnut != 0){
                btnDecreaseHazelNutMilkTea.isEnabled = true
            }

            if(totalQuantityMilkTeaHorlicks != 0){
                btnDecreaseMilkTeaHorlicks.isEnabled = true
            }

            if(totalQuantityOrgPearlMilkTea != 0){
                btnDecreaseOrgPearlMilkTea.isEnabled = true
            }

            if(totalQuantityRedBeanPear != 0){
                btnDecreaseRedBeanPearl.isEnabled = true
            }

            if(totalQuantitySigBrownSugarPearl != 0){
                btnDecreaseSigBrownSugar.isEnabled = true
            }

            btnReorderTeaLife.isVisible = false
            btnConfirmOrderTeaLife.isVisible = false
            btnPlaceOrderTeaLife.isVisible = true
        }

        btnConfirmOrderTeaLife.setOnClickListener()
        {
            Go2Payment()
        }
    }

    fun Go2Payment()
    {
        var intent = Intent(this, PaymentOrder::class.java)

        intent.putExtra("TotalQty", txtTotalTeaLifeQuantity.text.toString())
        intent.putExtra("TotalEstPrice", txtTotalTeaLifeEstimatePrice.text.toString())
        intent.putExtra("UserEmail", userEmail)
        startActivity(intent)
    }
}
