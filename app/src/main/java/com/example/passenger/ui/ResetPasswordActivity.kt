package com.example.passenger.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.passenger.R
import com.example.passenger.utils.isEmailValid
import com.example.passenger.utils.toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        button_reset_password.setOnClickListener {
            val email = text_email.text.toString().trim()

            if (isEmailValid(text_email)) {
                progressbar.visibility = View.VISIBLE

                FirebaseAuth.getInstance()
                    .sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        progressbar.visibility = View.GONE

                        if (task.isSuccessful) {
                            this.toast("Check your email")
                        } else {
                            this.toast(task.exception?.message!!)
                        }
                    }
            }
        }
    }
}
