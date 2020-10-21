package com.example.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

//interface to Firebase
import com.google.firebase.auth.FirebaseAuth;

class Register : AppCompatActivity() {

    //create Firebase references
    private var mAuth: FirebaseAuth? = null
    private val TAG = "RegisterUserToFirebase"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //get a references to the firebase auth object
        mAuth = FirebaseAuth.getInstance();

        btnBackToLogin.setOnClickListener{
            txtRegEmailAddress.setText("");
            txtRegPassword.setText("");

            Go2LoginPage()
        }

        btnConfirmRegister.setOnClickListener {
            if (txtRegEmailAddress.text.isNotEmpty() && txtRegPassword.text.isNotEmpty()) {
                createAccount(txtRegEmailAddress.text.toString(), txtRegPassword.text.toString()) // directly call the method
               }
            else {
                Toast.makeText(applicationContext, "Please Fill In Details", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    fun Go2LoginPage(){
        var intent = Intent(this, LoginPage::class.java)
        startActivity(intent)
    }

    //create new user account
    private fun createAccount(email: String, password: String){
        Log.e(TAG, "createAccount:" + email)//for debug
        mAuth!!.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    Log.d(TAG, "createAccount: Success!")
                    val user = mAuth!!.currentUser
                    if(user != null){
                        //blank
                    }
                    Toast.makeText(applicationContext, "Account Created Successful", Toast.LENGTH_LONG).show()
                    txtRegEmailAddress.isEnabled = false
                    txtRegPassword.isEnabled = false

                }

                //if user exist in Firebase
                //also perform format check
                else{
                    Log.e(TAG, "createAccount: Failed", task.exception)
                    Toast.makeText(applicationContext, "Account Create Fail", Toast.LENGTH_LONG).show()
                }
            }
    }
}
