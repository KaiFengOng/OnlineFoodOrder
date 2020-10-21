package com.example.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class LoginPage : AppCompatActivity() {

    //Create Firebase reference
    private var mAuth: FirebaseAuth? = null
    private val TAG = "LogUserToFirebase"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get a reference to the Firebase auth object to initialize
        mAuth = FirebaseAuth.getInstance()

        //To Login
        btnLogin.setOnClickListener{
            //if email Address and Password not Empty
            if(txtEmailAddress.text.isNotEmpty() && txtPassword.text.isNotEmpty())
            {
                signIn(txtEmailAddress.text.toString(), txtPassword.text.toString())
            }

            //if either one is empty
            else{
                Toast.makeText(applicationContext, "Please Enter all Required Field", Toast.LENGTH_LONG).show()
            }
        }

        //To Reset Password
        btnResetPassword.setOnClickListener{
            //if email Address is not empty
            if(txtEmailAddress.text.isNotEmpty()){
                //will call the reset password method
                resetPassword(txtEmailAddress.text.toString())
            }

            //if the email address is not enter
            else{
                Toast.makeText(applicationContext, "Please Enter Your Email Address", Toast.LENGTH_LONG).show()
            }
        }
    }

    //go to register page
    fun Go2Register(view: View) {
        var intent = Intent(this, Register::class.java)
        startActivity(intent)
    }

    //go to Menu & Order page
    fun Go2MenuOrderPage(){
        var intent = Intent(this, MenuOrderPage::class.java)
        intent.putExtra("UserEmail", txtEmailAddress.text.toString())
        startActivity(intent)
    }

    //sign in to current user -> do verification from database -> authentication
    private fun signIn(email:String, password:String){
        mAuth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    //if user enter correctly
                    //if user exist
                    val user = mAuth!!.currentUser
                    Toast.makeText(applicationContext, "Welcome, Your Have Successful Login", Toast.LENGTH_LONG).show()
                    Log.d(TAG, "User Login Successful : " + email) // to trace whether user login successful or not

                    Go2MenuOrderPage()
                }

                // user enter incorrect email or password
                //user does not register before
                else{
                    Log.e(TAG, "SignIn: Failed", task.exception)// to trace whether user login succsful or not
                    Toast.makeText(applicationContext, "User Login Fail", Toast.LENGTH_LONG).show()
                }
            }
    }

    //to reset user login password
    private fun resetPassword(email: String){
        mAuth!!.sendPasswordResetEmail(email)
            .addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    val user = mAuth!!.currentUser
                    Toast.makeText(applicationContext, "Reset password Confirm Send Already Send To Your Email", Toast.LENGTH_LONG).show()
                }

                else{
                    Toast.makeText(applicationContext, "User email either incorrect or does not exist", Toast.LENGTH_LONG).show()
                }

            }

    }
}
