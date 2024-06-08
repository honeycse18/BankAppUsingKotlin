package com.example.bankappusingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class PasswordActivity : AppCompatActivity() {
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSubmitPassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSubmitPassword = findViewById(R.id.buttonSubmitPassword)

        buttonSubmitPassword.setOnClickListener {
            val password = editTextPassword.text.toString()
            if (password.isNotEmpty()) {
                // Handle password submission logic here
                Toast.makeText(this, "Password Submitted", Toast.LENGTH_SHORT).show()
                // For example, navigate to another screen after successful password input
                // val intent = Intent(this, AnotherActivity::class.java)
                // startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}