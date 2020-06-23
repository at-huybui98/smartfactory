package com.buivanhuybk16.firebase

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_finger.*

class FingerActivity : AppCompatActivity(), OnItemClickListener {

    private var toastV: Toast? = null
    private var database: DatabaseReference = FirebaseDatabase.getInstance().reference
    private var arrayEmployee: ArrayList<Employee> = ArrayList()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finger)
        database.child("status/wifi").setValue(0)



        button_finger_add.setOnClickListener {
//            for( i in 1..127) {
//                database.child("change/finger/$i/name").setValue("")
//            }
//            database.child("change/contro/device1").setValue(1)
//            database.child("change/contro/device2").setValue(1)
//            database.child("change/contro/device3").setValue(1)


            var showToast = ""

            var flat = 0
            if (editText_finger_name.text.isEmpty()) {
                showToast += "Bạn Chưa Nhập Tên\n"
                flat = 1
            }
            if (editText_finger_id.text.isEmpty()) {
                showToast += "Bạn Chưa Nhập ID\n"
                flat = 1
            }
            if (editText_finger_id.text.length > 20) {
                showToast += "Tên không dài hơn 20 ký tự"
                flat = 1
            }

            if (flat == 0) {
                val name = editText_finger_name.text.toString()
                val id = editText_finger_id.text.toString().toInt()
                if (id < 1 || id > 127) {
                    "ID Chỉ Được Trong Khoảng 1 đến 127".toast()
                } else {

                    database.child("change/finger/$id/name").setValue(name)
                }
            } else {
                showToast.toast()
            }
        }


        database.child("change/finger").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                var flat1 = 0

                if (flat1 == 0) {
                    arrayEmployee.clear()
                    for (id in 1..127) {

                        var name = p0.child("$id/name").getValue().toString()
                        if (name != "") {
                            arrayEmployee.add(Employee(R.drawable.ic_3d, "ID:$id", "$name"))
                        }
                    }

                    recyclerView_employee.adapter =
                        EmployeeAdapter(arrayEmployee, this@FingerActivity)
                    recyclerView_employee.layoutManager = LinearLayoutManager(this@FingerActivity)
                    recyclerView_employee.setHasFixedSize(true)
                }

            }
        })

    }
    override fun employee_OnItemClick(item: Employee, position: Int) {
        val intent = Intent(this@FingerActivity, InfoEmployeeActivity::class.java)
        intent.putExtra("name", item.name)
        intent.putExtra("id", item.id)
        startActivity(intent)

    }


    private fun Any.toast(
        context: Context = this@FingerActivity,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        toastV?.cancel()
        toastV = Toast.makeText(context, this.toString(), duration).apply { show() }
    }


}
