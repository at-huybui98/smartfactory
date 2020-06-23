package com.buivanhuybk16.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {

    val dataList = generateDataList()

    private var database: DatabaseReference = FirebaseDatabase.getInstance().reference

    val part        = "sensor/data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        database.child(part).addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                dataList[1].current = p0.child("device1/current").getValue().toString()
                dataList[1].voltage = p0.child("device1/voltage").getValue().toString()
                dataList[1].wattage = p0.child("device1/wattage").getValue().toString()

                dataList[2].current = p0.child("device2/current").getValue().toString()
                dataList[2].voltage = p0.child("device2/voltage").getValue().toString()
                dataList[2].wattage = p0.child("device2/wattage").getValue().toString()

                dataList[3].current = p0.child("device3/current").getValue().toString()
                dataList[3].voltage = p0.child("device3/voltage").getValue().toString()
                dataList[3].wattage = p0.child("device3/wattage").getValue().toString()

                recyclerView_data.adapter           = MachineAdapter(dataList)
                recyclerView_data.layoutManager     = LinearLayoutManager(this@DataActivity)
                recyclerView_data.setHasFixedSize(true)

            }
        })
    }

    private fun generateDataList(): List<machineClass>{
      val list = ArrayList<machineClass>()
        list.add(machineClass("Máy", "Dòng Diện","Điện áp","Công suất"))
        list.add(machineClass("Máy 1", "0","0","0"))
        list.add(machineClass("Máy 2", "0","0","0"))
        list.add(machineClass("Máy 3", "0","0","0"))
        return list
    }


}
