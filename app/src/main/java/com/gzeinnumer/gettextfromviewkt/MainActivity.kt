package com.gzeinnumer.gettextfromviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var list_of_items = arrayOf("Item 1", "Item 2", "Item 3")

    var tvValue: String? = null
    var edValue: String? = null
    var swValue: String? = null
    var spValue: String? = null
    var btnValue: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.setText("Hello World!").toString()
        tvValue = tv.text as String?

        ed.setText("Hello World!").toString()
        edValue = tv.text as String?

        sw?.setOnCheckedChangeListener { _, isChecked ->
            swValue = if (isChecked) "ON" else "OFF"
            Toast.makeText(this@MainActivity, swValue, Toast.LENGTH_SHORT).show()
            //change text to ON OFF
            sw.text = swValue
        }

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp!!.setAdapter(aa)

        sp!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                spValue = list_of_items[0]
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spValue = list_of_items[p2]
            }
        }

        btn?.setOnClickListener {
            btnValue = btn.text as String?

            Toast.makeText(applicationContext, "TextView : $tvValue", Toast.LENGTH_SHORT ).show()
            Toast.makeText(applicationContext, "EditText : $edValue", Toast.LENGTH_SHORT ).show()
            Toast.makeText(applicationContext, "Switch : $swValue", Toast.LENGTH_SHORT ).show()
            Toast.makeText(applicationContext, "Spinner : $spValue", Toast.LENGTH_SHORT ).show()
            Toast.makeText(applicationContext, "Button : $btnValue", Toast.LENGTH_SHORT ).show()
        }


    }
}
