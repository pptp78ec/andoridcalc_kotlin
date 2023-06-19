package com.example.andoridcalc_kotlin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private fun assignFunctionality(functionality: Functionality) {
        findViewById<Button>(R.id.b0).setOnClickListener { functionality.button_0() }
        findViewById<Button>(R.id.b1).setOnClickListener { functionality.button_1() }
        findViewById<Button>(R.id.b2).setOnClickListener { functionality.button_2() }
        findViewById<Button>(R.id.b3).setOnClickListener { functionality.button_3() }
        findViewById<Button>(R.id.b4).setOnClickListener { functionality.button_4() }
        findViewById<Button>(R.id.b5).setOnClickListener { functionality.button_5() }
        findViewById<Button>(R.id.b6).setOnClickListener { functionality.button_6() }
        findViewById<Button>(R.id.b7).setOnClickListener { functionality.button_7() }
        findViewById<Button>(R.id.b8).setOnClickListener { functionality.button_8() }
        findViewById<Button>(R.id.b9).setOnClickListener { functionality.button_9() }
        findViewById<Button>(R.id.bpoint).setOnClickListener { functionality.button_point() }
        findViewById<Button>(R.id.bclear).setOnClickListener { functionality.button_C() }
        findViewById<Button>(R.id.bdiv).setOnClickListener { functionality.button_Div() }
        findViewById<Button>(R.id.bmult).setOnClickListener { functionality.button_Mul() }
        findViewById<Button>(R.id.bminus).setOnClickListener { functionality.button_Sub() }
        findViewById<Button>(R.id.bplus).setOnClickListener { functionality.button_Add() }
        findViewById<Button>(R.id.bresult).setOnClickListener { functionality.button_Result() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actovity_main_linear)
        val functionality = Functionality(findViewById(R.id.results))
        assignFunctionality(functionality)
    }
}