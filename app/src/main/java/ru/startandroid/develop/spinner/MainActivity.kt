package ru.startandroid.develop.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val data = arrayListOf("one", "two", "three", "four", "five")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter

        spinner.prompt = "Title"
        spinner.setSelection(2)
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(baseContext, "Position = $position", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) { }
        }
    }
}
