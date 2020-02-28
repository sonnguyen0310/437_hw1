package com.sng.hw3_prob2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sng.hw3_prob2.model.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSignUp.setOnClickListener{
            val intent = Intent()
            val user = User(edtMail.text.toString(), edtFirstName.text.toString(), edtLast.text.toString(), edtPass.text.toString())
            intent.putExtra("USER", user)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
