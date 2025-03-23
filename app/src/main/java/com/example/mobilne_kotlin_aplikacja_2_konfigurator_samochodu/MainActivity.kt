package com.example.mobilne_kotlin_aplikacja_2_konfigurator_samochodu

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.carRadioGroup)
        val leatherSeat = findViewById<CheckBox>(R.id.CheckBoxLeatherSeat)
        val airCondition = findViewById<CheckBox>(R.id.CheckBoxAirConditioning)
        val orderButton = findViewById<Button>(R.id.orderButton)
        val carImageView = findViewById<ImageView>(R.id.coffyImigeView)
        val carOrder = findViewById<TextView>(R.id.carOrder)


        var whichCar = ""



        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            whichCar = "${radioButton.text}"
            when (checkedId) {
                R.id.suv_radiobutton -> carImageView.setImageResource(R.drawable.suv)
                R.id.sedan_radiobutton -> carImageView.setImageResource(R.drawable.sedan)
                R.id.hatchback_radiobutton -> carImageView.setImageResource(R.drawable.hatchback)
            }
        }




        var airConditionChecked = ""
        var leatherSeatCheked = ""

        airCondition.setOnCheckedChangeListener{_ , isChecked ->
            if (isChecked){
                airConditionChecked = "Tak"
            }
            else {
                airConditionChecked = "Nie"
            }
        }

        leatherSeat.setOnCheckedChangeListener{_ , isChecked ->
            if (isChecked){
                leatherSeatCheked = "Tak"
            }
            else {
                leatherSeatCheked = "Nie"
            }
        }

        orderButton.setOnClickListener{
            carOrder.text = "wybrałes : $whichCar \n" +
                    "wentylacja: $airConditionChecked \n" +
                    "skorzane siedzenia $leatherSeatCheked"
        }


    }

}
