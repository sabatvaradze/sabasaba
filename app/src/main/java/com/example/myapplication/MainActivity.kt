package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirm: EditText
    private lateinit var btnSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        registrationForm()
    }
    private fun init() {
        etEmail = findViewById(R.id.maili)
        etPassword = findViewById(R.id.paroli)
        etConfirm = findViewById(R.id.gameoreba)
        btnSubmit = findViewById(R.id.confirm_button)
    }
    private fun registrationForm() {
        btnSubmit.setOnClickListener {
            val etEmailText = etEmail.text.toString()
            val etPasswordText = etPassword.text.toString()
            val etConfirmText = etConfirm.text.toString()
            if (etEmailText.isEmpty() || etPasswordText.isEmpty() || etConfirmText.isEmpty()) {
                Toast.makeText(this, "ველი ცარიელია", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (!etEmailText.contains("@")) {
                Toast.makeText(this, "მეილი არ არსებობს", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (!etEmailText.contains(".")) {
                Toast.makeText(this, "მეილი არ არსებობს", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (etPasswordText.length <= 8) {
                Toast.makeText(this, "პაროლი ნაკლებია 9ზე სიმბოლოზე", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (!etPasswordText.contains("1") && !etPasswordText.contains("2") && !etPasswordText.contains(
                    "3") &&
                !etPasswordText.contains("4") && !etPasswordText.contains("5") && !etPasswordText.contains(
                    "6") &&
                !etPasswordText.contains("7") && !etPasswordText.contains("8") && !etPasswordText.contains(
                    "9") &&
                !etPasswordText.contains("0")
            ) {
                Toast.makeText(this, "პაროლი უნდა შეიცავდეს ციფრებს", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (etPasswordText != etConfirmText) {
                Toast.makeText(this, "პაროლები არ ემთხვევა", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                Toast.makeText(this,"მონაცემები შენახულია", Toast.LENGTH_SHORT).show()
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    etEmailText,etPasswordText
                )
                return@setOnClickListener
            }
        }
    }

}
