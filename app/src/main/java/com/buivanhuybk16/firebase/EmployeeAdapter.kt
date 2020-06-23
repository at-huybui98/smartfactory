package com.buivanhuybk16.firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_data_employee.view.*
import kotlinx.android.synthetic.main.item_machin.view.*

class EmployeeAdapter(private val employeeList: List<Employee>, var clickListner: OnItemClickListener): RecyclerView.Adapter<EmployeeAdapter.AdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_data_employee,parent,false)

        return AdapterViewHolder(itemView)
    }

    override fun getItemCount() = employeeList.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {

        holder.initialize(employeeList.get(position),clickListner)
    }

    class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var img         :ImageView  = itemView.imageView_img_item
        var name        :TextView = itemView.textView_name_item
        var id          :TextView = itemView.textView_id_item

        fun initialize(item: Employee, action:OnItemClickListener){

            img.setImageResource(item.img)
            name.text = item.name
            id.text     =item.id

            itemView.setOnClickListener{
                action.employee_OnItemClick(item,adapterPosition)
            }
        }


    }
}

interface OnItemClickListener{
  fun  employee_OnItemClick(item: Employee,position: Int)
}
