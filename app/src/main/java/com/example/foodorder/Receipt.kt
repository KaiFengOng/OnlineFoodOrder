package com.example.foodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_receipt.*


class Receipt : AppCompatActivity() {

    //variable
    var receiptPrice : Double = 0.00
    var receiptQuanty : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        txtreceiptQuanty.text = this.intent.getStringExtra("TotalQty")
        txtreceiptPrice.text = this.intent.getStringExtra("TotalEstPrice")
        txtTransactionID.text = this.intent.getStringExtra("TransactionID")

    }
}
