package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class MainActivity : AppCompatActivity() {

    var clickCount = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView = findViewById<TextView>(R.id.clickCountView)
        val clickMeButton = findViewById<TextView>(R.id.clickButton)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.nameText)
        val users = mutableMapOf<String, Int?>()

        clickMeButton.setOnClickListener {
            val userName = userNameTextInputView.editText?.text?.toString()
            val maskedUserName =
                if(userName.isNullOrEmpty()) "Somebody"
                else userName[0].uppercaseChar() + userName.substring(1)
                    .lowercase(Locale.getDefault())


            val usersAsString = StringBuilder("")

            clickCount++

            if (!users.containsKey(maskedUserName))
                users.put(maskedUserName, 1)
            else
                users.put(maskedUserName, users.get(maskedUserName)?.plus(1))

            for (key in users.keys) {
                usersAsString.append(key + " clicked " + users[key] + " times\n")
            }

            clickCountDisplayView.setText("$usersAsString")
        }
    }
}