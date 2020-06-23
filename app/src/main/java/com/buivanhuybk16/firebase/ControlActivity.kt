package com.buivanhuybk16.firebase

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_control.*
import android.os.CountDownTimer as CountDownTimer

class ControlActivity : AppCompatActivity() {

    val part_node = "change"

    private var toastV: Toast? = null

    private  var database: DatabaseReference = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        database.child("sensor/data").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                val status1 = p0.child("device1/status").getValue().toString().toInt()
                val status2 = p0.child("device2/status").getValue().toString().toInt()
                val status3 = p0.child("device3/status").getValue().toString().toInt()

                if(status1  == 1)
                    textView_machine_1.setTextColor(Color.parseColor("#00FF0D"))
                else
                    textView_machine_1.setTextColor(Color.parseColor("#FF0000"))

                if(status2  == 1)
                    textView_machine_2.setTextColor(Color.parseColor("#00FF0D"))
                else
                    textView_machine_2.setTextColor(Color.parseColor("#FF0000"))

                if(status3  == 1)
                    textView_machine_3.setTextColor(Color.parseColor("#00FF0D"))
                else
                    textView_machine_3.setTextColor(Color.parseColor("#FF0000"))

                if(status1  == 1   &&  status2 == 1 && status3 == 1)
                    textView_machine_all.setTextColor(Color.parseColor("#00FF0D"))
                else
                    textView_machine_all.setTextColor(Color.parseColor("#FF0000"))

            }

        })

        button_on_1.setOnClickListener {
           database.child("$part_node/contro/device1").setValue(1)
        }
        button_off_1.setOnClickListener {
            database.child("$part_node/contro/device1").setValue(0)
        }
//--------------------------
        button_on_2.setOnClickListener {
            database.child("$part_node/contro/device2").setValue(1)
        }
        button_off_2.setOnClickListener {
            database.child("$part_node/contro/device2").setValue(0)
        }
//-------------------------
        button_on_3.setOnClickListener {
            database.child("$part_node/contro/device3").setValue(1)
        }
        button_off_3.setOnClickListener {
            database.child("$part_node/contro/device3").setValue(0)
        }
//----------------------
            button_on_all.setOnClickListener {
                database.child("$part_node/contro/device1").setValue(1)
                database.child("$part_node/contro/device2").setValue(1)
                database.child("$part_node/contro/device3").setValue(1)
            }
            button_off_all.setOnClickListener {
                database.child("$part_node/contro/device1").setValue(0)
                database.child("$part_node/contro/device2").setValue(0)
                database.child("$part_node/contro/device3").setValue(0)
            }


    }


private fun Any.toast(
        context: Context = this@ControlActivity,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        toastV?.cancel()
        toastV = Toast.makeText(context, this.toString(), duration).apply { show() }
    }
}
