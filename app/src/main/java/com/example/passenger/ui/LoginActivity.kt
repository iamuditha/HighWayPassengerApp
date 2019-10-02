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
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        button_sign_in.setOnClickListener {
            val email = edit_text_email.text.toString().trim()
            val password = edit_text_password.text.toString().trim()

            if (isEmailValid(edit_text_email) && isPasswordValid(
                    edit_text_password
                )
            ) {
                loginUser(email, password)
            }
        }
        //register text view click event
        text_view_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        text_view_forget_password.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }
    }

    private fun loginUser(email: String, password: String) {
        progressbar.visibility = View.VISIBLE

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            progressbar.visibility = View.INVISIBLE
            if (task.isSuccessful) {
                login()
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
