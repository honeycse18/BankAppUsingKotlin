package com.example.bankappusingkotlin





import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EnterPinActivity : AppCompatActivity() {
    private lateinit var pinDigit1: EditText
    private lateinit var pinDigit2: EditText
    private lateinit var pinDigit3: EditText
    private lateinit var pinDigit4: EditText
    private lateinit var buttonSubmitPin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_pin)

        pinDigit1 = findViewById(R.id.pinDigit1)
        pinDigit2 = findViewById(R.id.pinDigit2)
        pinDigit3 = findViewById(R.id.pinDigit3)
        pinDigit4 = findViewById(R.id.pinDigit4)
        buttonSubmitPin = findViewById(R.id.buttonSubmitPin)

        buttonSubmitPin.setOnClickListener {
            val pin = pinDigit1.text.toString() + pinDigit2.text.toString() + pinDigit3.text.toString() + pinDigit4.text.toString()
            if (pin.length == 4) {
                // Handle PIN verification logic here
                Toast.makeText(this, "PIN Submitted: $pin", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, WalletActivity::class.java)
                startActivity(intent)
                // For example, navigate to another screen after successful PIN input
                // val intent = Intent(this, AnotherActivity::class.java)
                // startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a 4-digit PIN", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
