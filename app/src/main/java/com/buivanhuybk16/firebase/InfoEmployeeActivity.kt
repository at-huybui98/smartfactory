package com.buivanhuybk16.firebase

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_info_employee.*

class InfoEmployeeActivity : AppCompatActivity() {
    private var toastV:         Toast? = null
    private var database: DatabaseReference = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_employee)

        var count:Int = 0;

        textView_info_name.text = intent.getStringExtra("name")
        val id = intent.getStringExtra("id")
        textView_info_id.text = id

        button_remove_finger.setOnClickListener {
            if(count == 0) {
                "Xác nhận lần 1 để xóa nhân viên".toast()
                count++
            }
            else if(count == 1){
                "Xác nhận lần 2 để xóa nhân viên".toast()
                count++
            }
            else if(count == 2){


                database.child("change/finger/${id.subSequence(3,id.length)}/name").setValue("")
                "Đã xóa nhân viên".toast()
                val intent = Intent(this@InfoEmployeeActivity, FingerActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()

            }
        }
    }

    private fun Any.toast(context: Context = this@InfoEmployeeActivity, duration: Int = Toast.LENGTH_SHORT) {
        toastV?.cancel()
        toastV = Toast.makeText(context, this.toString(), duration).apply { show() }
    }
}

