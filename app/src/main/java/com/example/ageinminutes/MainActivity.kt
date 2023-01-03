package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        val selectedDate = findViewById<TextView>(R.id.tvSelectedDate)
        val ageInMinutesTextView = findViewById<TextView>(R.id.tvSelectedDateInMinutes)

        btnDatePicker.setOnClickListener{ view ->
            clickDatePicker(view, selectedDate, ageInMinutesTextView)
//            Toast.makeText(this, "Button Works!", Toast.LENGTH_LONG).show()
        }
    }

    fun clickDatePicker(view: View, selectedDateTextView: TextView, ageInMinutesTextView: TextView){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener
        { datePicker, i, i2, i3 ->
            val selectedDate = "$i3/${i2+1}/$i"
            selectedDateTextView.text = selectedDate
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val dateInMinutes = theDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time / 60000

            val differenceInMinutes = currentDateInMinutes - dateInMinutes


            ageInMinutesTextView.text = differenceInMinutes.toString()
        }
            , year
            , month
            , day
        )

        dpd.datePicker.maxDate = Date().time - 86400000
        dpd.show()
    }
}