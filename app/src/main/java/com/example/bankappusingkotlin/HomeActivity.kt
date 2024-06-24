package com.example.bankappusingkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText



import android.widget.Button

import android.widget.Toast


class HomeActivity : AppCompatActivity() {
    private lateinit var editTextInput: EditText
    private lateinit var buttonConfirm: Button
    private lateinit var buttonSkip: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        editTextInput = findViewById(R.id.editTextInput)
        buttonConfirm = findViewById(R.id.buttonConfirm)
        buttonSkip = findViewById(R.id.buttonSkip)

        buttonConfirm.setOnClickListener {
            val inputText = editTextInput.text.toString()
            if (inputText.isNotEmpty()) {
                Toast.makeText(this, "Confirmed: $inputText", Toast.LENGTH_SHORT).show()
                // Navigate to EnterPinActivity
                val intent = Intent(this, EnterPinActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter something", Toast.LENGTH_SHORT).show()
            }
        }

        buttonSkip.setOnClickListener {
            Toast.makeText(this, "Skipped", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, WalletActivity::class.java)
            startActivity(intent)
            // Handle skip logic here, e.g., navigate to another screen
        }
    }
}
