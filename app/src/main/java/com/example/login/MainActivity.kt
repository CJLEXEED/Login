package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null
    private var checkBoxTerms: CheckBox? = null
    private var buttonProceed: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply system bar insets for edge-to-edge experience
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Views
        val emailEditText: EditText = findViewById(R.id.editTextEmail)
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)
        val loginButton: Button = findViewById(R.id.buttonProceed)
        val rememberCheckBox: CheckBox = findViewById(R.id.checkBoxTerms)

        // Set Button OnClickListener
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val isTermsChecked = rememberCheckBox.isChecked

            // Validate inputs
            when {
                email.isEmpty() || password.isEmpty() -> {
                    Toast.makeText(this, R.string.error_empty_fields, Toast.LENGTH_SHORT).show()
                }

                !isValidEmail(email) -> {
                    Toast.makeText(this, "Please enter a valid email with '@'", Toast.LENGTH_SHORT).show()
                }

                !isTermsChecked -> {
                    Toast.makeText(this, R.string.error_accept_terms, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(
                        this,
                        if (isTermsChecked) "Login successful with 'Remember Password' enabled!"
                        else "Login successful!",
                        Toast.LENGTH_SHORT
                    ).show()
                    // Handle further login logic here
                }
            }
        }
    }// Function to validate email
    private fun isValidEmail(email: String): Boolean {
        return email.contains("@,com")
    }
}

