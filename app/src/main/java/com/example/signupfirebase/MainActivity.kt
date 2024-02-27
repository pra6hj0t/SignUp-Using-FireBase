 package com.example.signupfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

 class MainActivity : AppCompatActivity() {
     lateinit var DataBase : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val signup = findViewById<Button>(R.id.btnSignup)
        val name  = findViewById<EditText>(R.id.etName)
        val uniqueId = findViewById<EditText>(R.id.etUniqueId)
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)



        signup.setOnClickListener {
            val username = name.text.toString()
            val userUniqueId = uniqueId.text.toString()
            val userEmail = email.text.toString()
            val userPass = password.text.toString()

            val user = Users(username,userUniqueId,userEmail,userPass)
            DataBase=FirebaseDatabase.getInstance().getReference("Users")
            DataBase.child(userUniqueId).setValue(user).addOnSuccessListener {
                name.text.clear()
                uniqueId.text.clear()
                email.text.clear()
                password.text.clear()
                Toast.makeText(this,"Registered",Toast.LENGTH_SHORT).show()
            }



        }
    }
}