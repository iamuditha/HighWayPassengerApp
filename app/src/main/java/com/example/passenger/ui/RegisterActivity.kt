package com.example.passenger.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.passenger.R
import com.example.passenger.utils.isEmailValid
import com.example.passenger.utils.isPasswordValid
import com.example.passenger.utils.login
import com.example.passenger.utils.toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth // Initialize the Firebase Auth Instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        //register button event
        button_register.setOnClickListener {
            val email = edit_text_email.text.toString().trim()
            val password = edit_text_password.text.toString().trim()

            if (isEmailValid(edit_text_email) && isPasswordValid(
                    edit_text_password
                )
            ) {
                registerUser(email, password)
            }
        }

        //Login here click event
        text_view_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun registerUser(email: String, password: String) {
        progressbar.visibility = View.VISIBLE
        //register the user in the db
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            progressbar.visibility = View.INVISIBLE
            //start the next activity after successful registration
            if (task.isSuccessful) {
                login()
                //display any error message
            } else {
                task.exception?.message?.let {
                    toast(it)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        mAuth.currentUser?.let {
            login()
        }
    }
}

