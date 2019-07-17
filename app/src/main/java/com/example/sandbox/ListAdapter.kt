package com.example.sandbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sandbox.com.example.sandbox.model.CompanyModel
import kotlinx.android.synthetic.main.item_list.view.*

class ListAdapter(private val myDataSet: ArrayList<CompanyModel>):RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    // item_list.xmlとの紐付けを行なっている
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val compId: TextView = view.comp_id
        val compName: TextView = view.comp_name
        val compAddress: TextView = view.comp_address
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.compId.text = myDataSet[position].id.toString()
        holder.compName.text = myDataSet[position].name
        holder.compAddress.text = myDataSet[position].adress
    }

    override  fun getItemCount() = myDataSet.size

}
