package com.example.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_order_page.*
import java.text.SimpleDateFormat
import java.util.*

class MenuOrderPage : AppCompatActivity() {

    //variable
    var userEmail: String? = null //to hold user email


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_order_page)

        val startOrderTime = Calendar.getInstance(Locale.ENGLISH)
        SystemClock.text = SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(startOrderTime.time)

        //set user email text
        //userEmail = this.intent.getStringExtra("UserEmail")
        //txtMenuOrderEmail.text = userEmail

        btnTaxesChicken.setOnClickListener()
        {
            Go2TaxesChicken()
        }

        btnKFC.setOnClickListener()
        {
            Go2KFC()
        }

        btnMcDonals.setOnClickListener()
        {
            Go2McDonalds()
        }

        btnTeaLive.setOnClickListener()
        {
            Go2TeaLive()
        }

        btnDominoPizza.setOnClickListener()
        {
            Go2DominoPizza()
        }
    }



    fun Go2TaxesChicken()
    {
        var intent = Intent(this, TaxesChicken::class.java)
        startActivity(intent)

    }

    fun Go2KFC()
    {
        var intent = Intent(this,KFC::class.java)
        startActivity(intent)
    }

    fun Go2McDonalds()
    {
        var intent = Intent(this, McDonalds::class.java)
        startActivity(intent)
    }

    fun Go2TeaLive()
    {
        var intent = Intent(this, TeaLife::class.java)
        startActivity(intent)
    }

    fun Go2DominoPizza()
    {
        var intent = Intent(this, DominoPizza::class.java)
        startActivity(intent)
    }

}
