package com.example.foodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_payment_order.*
import androidx.core.view.isVisible
import java.text.SimpleDateFormat
import android.content.Intent
import java.util.*

class PaymentOrder : AppCompatActivity() {

    //variable
    var totalChargeIncludeDelivery : Double = 0.00
    var totalFinalQty : Int = 0 //final usage
    var totalTempPrice : Double = 0.00 //use for calculate the delivery charge
    var totalFinalCharge : Double = 0.00//use to combine calculate the total price order included the delivery charge
    var deliveryCharge : Double = 0.08
    var transactionID : String? = null

    var TAG = "RegisterCard" //This Activity Name
    var userEmail: String? = null

    val currentTime = Calendar.getInstance(Locale.ENGLISH) //to get local time
    val cardID = "TranID" + SimpleDateFormat("ddMMyyyyHHmmss").format(currentTime.time)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_order)

        btnConfirmCancel.isVisible = false
        btnConfirmReturn.isVisible = false

        txtCardNum.isEnabled = false
        txtCVCNum.isEnabled = false
        txtCardExpDate.isEnabled = false

        //This Will be final cause no calculation included
        totalFinalQty = this.intent.getStringExtra("TotalQty").toInt()
        txtFinalTotalQuantity.text = totalFinalQty.toString()

        //This need to calculate the total price -> include the delivery charge
        totalTempPrice = this.intent.getStringExtra("TotalEstPrice").toDouble()
        totalFinalCharge = (totalTempPrice * deliveryCharge) + totalTempPrice

        txtFinalTotalCharge.text = totalFinalCharge.toString()

        radioMasterCard.setOnClickListener()
        {
            txtCardNum.isEnabled = true
            txtCVCNum.isEnabled = true
            txtCardExpDate.isEnabled = true
        }

        radioVisa.setOnClickListener()
        {
            txtCardNum.isEnabled = true
            txtCVCNum.isEnabled = true
            txtCardExpDate.isEnabled = true
        }


        btnCancelPayment.setOnClickListener()
        {
            btnConfirmCancel.isVisible = true
            btnConfirmReturn.isVisible = true

            btnConfirmPayment.isVisible = false
            btnCancelPayment.isVisible = false

            txtCardNum.isEnabled = false
            txtCVCNum.isEnabled = false
            txtCardExpDate.isEnabled = false

            radioMasterCard.isEnabled = false
            radioVisa.isEnabled = false
        }

        btnConfirmReturn.setOnClickListener()
        {
            //to hide the button
            btnCancelPayment.isVisible = true
            btnConfirmCancel.isVisible = true
            btnConfirmPayment.isVisible = true

            txtCardNum.isEnabled = true
            txtCVCNum.isEnabled = true
            txtCardExpDate.isEnabled = true

            radioMasterCard.isEnabled = true
            radioVisa.isEnabled = true

            btnConfirmReturn.isVisible = false
            btnConfirmCancel.isVisible = false
        }

        btnConfirmCancel.setOnClickListener()
        {
            Go2MenuOrderPage()
            Toast.makeText(applicationContext, "Your Order Will Be Cancel", Toast.LENGTH_LONG).show()
        }

        btnConfirmPayment.setOnClickListener()
        {
            //to confirm whether user enter correct or not
            if(txtCardNum.text.isEmpty() || txtCVCNum.text.isEmpty() || txtCardExpDate.text.isEmpty())
            {
                Toast.makeText(applicationContext, "Please Fill In All The Details", Toast.LENGTH_LONG).show()
            }

            //if all the required entered is not empty
            if(txtCardNum.text.isNotEmpty() || txtCVCNum.text.isNotEmpty() || txtCardExpDate.text.isNotEmpty())
            {
                if(txtCardNum.length() == 16 && txtCVCNum.length() == 3 && isValidExpDateFormat(txtCardExpDate.text.toString()))
                {
                    //if all is valid -> txtCardNum, txtCVCNum, txtCardExpDate
                    writePayment()
                    txtCardNum.isEnabled = false
                    txtCVCNum.isEnabled = false
                    txtCardExpDate.isEnabled = false

                    radioMasterCard.isEnabled = false
                    radioVisa.isEnabled = false

                    Go2Recepit()
                }

                else
                {
                    Toast.makeText(applicationContext, "Some of Your Entered Field Is Incorrect", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun Go2MenuOrderPage()
    {
        var intent = Intent(this,MenuOrderPage::class.java)
        startActivity(intent)
    }

    fun Go2Recepit()
    {
        var intent = Intent(this, Receipt::class.java)
        intent.putExtra("TotalQty", txtFinalTotalQuantity.text)
        intent.putExtra("TotalEstPrice", txtFinalTotalCharge.text)
        intent.putExtra("UserEmail", userEmail)
        intent.putExtra("TransactionID", cardID)
        startActivity(intent)
    }

    //this method will be call when the button confirm payment is clicked
    private fun writePayment() {
        var card = Card(txtCardNum.text.toString(),txtCardExpDate.text.toString(),txtCVCNum.text.toString(),
            totalFinalQty, totalFinalCharge)
        val currentTime = Calendar.getInstance(Locale.ENGLISH) //to get local time

        //to generate the transaction ID using the date, month, year, hours, min, and sec
        //val cardID = "TranID" + SimpleDateFormat("ddMMyyyyHHmmss").format(currentTime.time)


        //Write transaction to the database
        FirebaseDatabase.getInstance().reference.child("cards")
            .child(cardID).setValue(card).addOnSuccessListener {
                //Write was Successful!
                Toast.makeText(applicationContext, "Your Payment Is Successful", Toast.LENGTH_LONG).show()
            }
                .addOnFailureListener{
                    //Write was Failed
                }
    }

    //to convert string to long type
    /*private fun convertStringtoLong(data: String?): Double{
        try{
            if(!data.isNullOrEmpty()){
                return data!!.toDouble()
            }
        }catch (exception: NumberFormatException){
            return -1.00
        }
        return 0.00
    }*/

    //to convert string to Int type
    /*private fun convertStringtoInt(data: String?) : Int{
        try{
            if(!data.isNullOrEmpty()){
                return data!!.toInt()
            }
        }catch (exception: NumberFormatException){
            return -1
        }
        return 0
    }*/

    //to check credit card exp date format -> mm/yy
    private fun isValidExpDateFormat(expDate: String?): Boolean {
        return (expDate!!.matches("^\\d{2}\\/\\d{2}\$".toRegex()))
    }

    //to get username from user email address
    private fun getUsernameFromEmail(email: String?): String
    {
        return if(email!!.contains("@"))
        {
            email.split("@".toRegex()).dropLastWhile { it.isEmpty()}.toTypedArray()[0]
        }
        else
        {
            email
        }
    }
}
