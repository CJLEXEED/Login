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
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        checkBoxTerms = findViewById(R.id.checkBoxTerms)
        buttonProceed = findViewById(R.id.buttonProceed)

        // Set Button OnClickListener
        buttonProceed?.setOnClickListener {
            val email = editTextEmail?.text.toString()
            val password = editTextPassword?.text.toString()
            val isTermsChecked = checkBoxTerms?.isChecked ?: false

            // Check for input validation
            when {
                email.isEmpty() || password.isEmpty() -> {
                    Toast.makeText(this, R.string.error_empty_fields, Toast.LENGTH_SHORT).show()
                }
                !isTermsChecked -> {
                    Toast.makeText(this, R.string.error_accept_terms, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, R.string.login_successful, Toast.LENGTH_SHORT).show()
                    // Handle further login logic here
                }
            }
        }
    }
}
