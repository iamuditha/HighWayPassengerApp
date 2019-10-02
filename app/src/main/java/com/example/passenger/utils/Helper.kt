package com.example.passenger.utils

import android.content.Context
import android.content.Intent
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.passenger.ui.HomeActivity
import com.example.passenger.ui.LoginActivity

//extension function to display the toast message
fun Context.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


fun Context.login() {
    val intent = Intent(this, HomeActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}

fun Context.logout() {
    val intent = Intent(this, LoginActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}

fun isEmailValid(view: EditText): Boolean {
    if (view.text.isEmpty()) {
        view.error = "Email Required"
        view.requestFocus()
        return false
    } else if (!Patterns.EMAIL_ADDRESS.matcher(view.text).matches()) {
        view.error = "Valid Email Required"
        view.requestFocus()
        return false
    }
    return true
}

fun isPasswordValid(view: EditText): Boolean {
    if (view.text.isEmpty() || view.text.length < 6) {
        view.error = "Password Required"
        view.requestFocus()
        return false
    }
    return true
}