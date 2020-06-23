package com.buivanhuybk16.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button_main_finger.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity,FingerActivity::class.java)
            startActivity(intent)
        }

        button_main_data.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity,DataActivity::class.java)
            startActivity(intent)
        }

        button_main_control.setOnClickListener {
            val intent:Intent = Intent(this@MainActivity,ControlActivity::class.java)
            startActivity(intent)
        }

        button_main_info.setOnClickListener {
            val intent:Intent = Intent(this@MainActivity,InfomationActivity::class.java)
            startActivity(intent)
        }


    }


}
