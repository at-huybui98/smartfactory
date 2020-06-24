package com.buivanhuybk16.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
//    private var database: DatabaseReference = FirebaseDatabase.getInstance().reference
//    var count_wifi = 0;
//    var wifi_status = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val timer = object: CountDownTimer(500, 500) {
//            override fun onFinish() {

//            }
//
//            override fun onTick(p0: Long) {

//            }
//
//
//        }
//        timer.start()
//        database.child("status").addValueEventListener(object : ValueEventListener{
//            override fun onCancelled(p0: DatabaseError) {
//
//            }
//
//            override fun onDataChange(p0: DataSnapshot) {
//                val count_new: Int = p0.child("wifi").getValue() as Int
//                if(count_new > count_new)
//                {
//                    wifi_status = true
//                }
//
//            }
//        })



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
