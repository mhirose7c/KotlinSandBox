package com.example.sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sandbox.com.example.sandbox.model.CompanyModel
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "ListActivity"

        val itemListView = item_list

        itemListView.layoutManager = LinearLayoutManager(this)
        itemListView.adapter = ListAdapter(listFactory())

    }

    private fun listFactory(): ArrayList<CompanyModel>{
        var companyList: ArrayList<CompanyModel> = arrayListOf()
        for (i in 1..20){
            val company:CompanyModel = CompanyModel().also {
                    it.id = i
                    it.name = "company${i}"
                    it.adress = "東京都"
                }
            companyList.add(company)
        }
        return companyList
    }
}
