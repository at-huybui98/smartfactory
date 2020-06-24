package com.buivanhuybk16.firebase

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buivanhuybk16.firebase.R.drawable.back_ground
import com.buivanhuybk16.firebase.R.drawable.button_layout
import kotlinx.android.synthetic.main.item_machin.view.*

class MachineAdapter(private val machineList: List<machineClass>): RecyclerView.Adapter<MachineAdapter.AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_machin,parent,false)

        return AdapterViewHolder(itemView)
    }

    override fun getItemCount() = machineList.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val currentItem =  machineList[position]



        holder.name.text        = currentItem.name_machine
        holder.current.text     = currentItem.current
        holder.voltage.text     = currentItem.voltage
        holder.wattage.text     = currentItem.wattage
        val status       = currentItem.status

        if(status == "0") {
            holder.current.text = "0"
            holder.voltage.text = "0"
            holder.wattage.text = "0"
            holder.name.setBackgroundColor(Color.parseColor("#CD5858"))
            holder.current.setBackgroundColor(Color.parseColor("#CD5858"))
            holder.voltage.setBackgroundColor(Color.parseColor("#CD5858"))
            holder.wattage.setBackgroundColor(Color.parseColor("#CD5858"))
        }

    }



    class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name        :TextView = itemView.item_name
        val current     :TextView = itemView.item_current
        val voltage     :TextView = itemView.item_voltage
        val wattage     :TextView = itemView.item_wattage

    }
}