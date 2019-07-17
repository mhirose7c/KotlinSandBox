package com.example.sandbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEXTDATA = "com.example.sandbox.TEXTDATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionButton = this.findViewById<Button>(R.id.button)
        val nextPageButton = this.findViewById<Button>(R.id.nextPageButton)
        val listPageButton = this.findViewById<Button>(R.id.listPageButton)
        val textField = this.findViewById<EditText>(R.id.editText)
        val outputLabel = this.findViewById<TextView>(R.id.textView)

        actionButton.setOnClickListener {
            if (textField.text.isNotEmpty()) {
                outputLabel.text = textField.text
            } else {
                textField.error = "文字を入力してください"
                outputLabel.text = "表示するテキストを入力してください"
            }
        }

        nextPageButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_TEXTDATA, textField.text.toString())
            startActivity(intent)
        }

        listPageButton.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

    }

}
