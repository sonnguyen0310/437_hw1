package com.sng.hw3_prob2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sng.hw3_prob2.model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnSignUp
import android.net.Uri




class MainActivity : AppCompatActivity() {
    val REGISTER_REQUEST_CODE = 1
    val users = arrayListOf(
        User("user1@gmail.com", "Daniel", "Hen", "a123"),
        User("user2@gmail.com", "Rich", "Tay", "a123"),
        User("user3@gmail.com", "Hoang", "Nguyen", "a123"),
        User("user4@gmail.com", "Michale", "Li", "a123"),
        User("user5@gmail.com", "Henry", "Ten", "a123")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            users.forEach {
                if (it.email.equals(edtMail.text.toString()) && it.pass.equals(edtPass.text.toString())) {
                    val i = Intent(this, ShoppingCategory::class.java)
                    i.putExtra("USER", it);
                    startActivity(i)
                }
            }
        }

        btnSignUp.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivityForResult(i, REGISTER_REQUEST_CODE)
        }

        tvForget.setOnClickListener {
            if (edtMail.text.isEmpty()) {
                Toast.makeText(this, "Input email first", Toast.LENGTH_SHORT).show()
            } else {
                var mess = "Your Email not match"
                users.forEach {
                    if (it.email.equals(edtMail.text.toString())) {
                        mess = it.pass
                    }
                }
                val emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.data = Uri.parse("mailto:")
                emailIntent.type = "text/plain"
                emailIntent.putExtra(Intent.EXTRA_EMAIL, edtMail.text)
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your password")
                emailIntent.putExtra(Intent.EXTRA_TEXT, mess)

                emailIntent.type = "message/rfc822"

                try {
                    startActivity(
                        Intent.createChooser(
                            emailIntent,
                            "Send email using..."
                        )
                    )
                } catch (ex: android.content.ActivityNotFoundException) {
                    Toast.makeText(
                        this,
                        "No email clients installed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            data?.let {
                if (it.hasExtra("USER")) {
                    users.add(it.getSerializableExtra("USER") as User)
                }
            }
        }
    }
}
