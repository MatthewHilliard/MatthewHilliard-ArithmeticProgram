package com.example.arithmeticprogram

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operations = resources.getStringArray(R.array.operations)
        val spinner = findViewById<Spinner>(R.id.operationSelect)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        var currOperation = operations[0]

        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currOperation = operations[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected (optional)
            }
        }

        val resultText = findViewById<TextView>(R.id.resultText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val numberOne = findViewById<EditText>(R.id.NumberInputOne)
        val numberTwo = findViewById<EditText>(R.id.NumberInputTwo)

        calculateButton.setOnClickListener{
            if(numberOne.text.isBlank()){
                val toast = Toast.makeText(this, "First Input is Blank", Toast.LENGTH_SHORT)
                toast.show()
            }
            else if(numberTwo.text.isBlank()){
                val toast = Toast.makeText(this, "Second Input is Blank", Toast.LENGTH_SHORT)
                toast.show()
            }
            else if(numberTwo.text.toString().substring(0,1) == "0" && currOperation == operations[3]){
                val toast = Toast.makeText(this, "Cannot Divide by Zero", Toast.LENGTH_SHORT)
                toast.show()
            }
            else{
                val numberOneVal = numberOne.text.toString().toDouble()
                val numberTwoVal = numberTwo.text.toString().toDouble()
                if(currOperation == operations[0]){
                    resultText.text = (numberOneVal + numberTwoVal).toString()
                }
                if(currOperation == operations[1]){
                    resultText.text = (numberOneVal - numberTwoVal).toString()
                }
                if(currOperation == operations[2]){
                    resultText.text = (numberOneVal * numberTwoVal).toString()
                }
                if(currOperation == operations[3]){
                    resultText.text = (numberOneVal / numberTwoVal).toString()
                }
                if(currOperation == operations[4]){
                    resultText.text = (numberOneVal % numberTwoVal).toString()
                }
            }
        }
    }
}