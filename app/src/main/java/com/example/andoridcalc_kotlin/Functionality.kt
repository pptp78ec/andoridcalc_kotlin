package com.example.andoridcalc_kotlin

import android.annotation.SuppressLint
import android.util.Log
import android.widget.EditText
import java.lang.Exception

class Functionality(private val resultField: EditText) {
    enum class Operators {
        Div,
        Mul,
        Add,
        Sub,
        None
    }

    private var first: Double = 0.0
    private var second: Double = 0.0
    private var isResultMode = false
    private var isOperatorMode = false
    private var currentOperator: Operators = Operators.None

    private fun clearInput() {
        resultField.setText("0")
    }

    private fun transformDoubleAndClearInput(): Double {
        return try {
            val ret = resultField.text.toString().toDouble()
            clearInput()
            ret
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
            0.0
        }
    }
    private fun checkOprModeResModeFalse_TFToDoubleAndClrInput_SetOprModeTrue(){
        if(!isOperatorMode && !isResultMode){
            first = transformDoubleAndClearInput()
            isOperatorMode = true
        }
    }

    @SuppressLint("SetTextI18n")
    private  fun inputNum(_number: String){
        if(!isResultMode){
            if(resultField.text.toString() == "0" && resultField.text.toString().length == 1){
                resultField.setText(_number)
                if(_number == "."){
                    resultField.setText("0")
                }
            }
            else{
                resultField.setText(resultField.text.toString() + _number)
            }
        }
    }
    fun button_C(){
        first = 0.0
        second = 0.0
        isOperatorMode = false
        isResultMode = false
        clearInput()
    }
    fun button_Div(){
        checkOprModeResModeFalse_TFToDoubleAndClrInput_SetOprModeTrue()
        currentOperator = Operators.Div
    }
    fun button_Sub(){
        checkOprModeResModeFalse_TFToDoubleAndClrInput_SetOprModeTrue()
        currentOperator = Operators.Sub
    }
    fun button_Mul(){
        checkOprModeResModeFalse_TFToDoubleAndClrInput_SetOprModeTrue()
        currentOperator = Operators.Mul
    }
    fun button_Add(){
        checkOprModeResModeFalse_TFToDoubleAndClrInput_SetOprModeTrue()
        currentOperator = Operators.Add
    }
    fun button_Result(){
        if(isOperatorMode){
            second = transformDoubleAndClearInput()
            isResultMode = true
            isOperatorMode = false

            val result: Double

            when (currentOperator){
                Operators.Div -> {
                    result = first / second
                    currentOperator = Operators.None
                    if(second != 0.0){
                        resultField.setText(result.toString())
                    }
                    else
                    {
                        button_C()
                    }

                }
                Operators.Mul -> {
                    result = first * second
                    currentOperator = Operators.None
                    resultField.setText(result.toString())
                }
                Operators.Add -> {
                    result = first + second
                    currentOperator = Operators.None
                    resultField.setText(result.toString())
                }
                Operators.Sub -> {
                    result = first - second
                    currentOperator = Operators.None
                    resultField.setText(result.toString())
                }
                Operators.None -> Log.i("Info", "User pressed enter w/o specifying any oprator")
            }
        }
    }
    fun button_1() = inputNum("1")
    fun button_2() = inputNum("2")
    fun button_3() = inputNum("3")
    fun button_4() = inputNum("4")
    fun button_5() = inputNum("5")
    fun button_6() = inputNum("6")
    fun button_7() = inputNum("7")
    fun button_8() = inputNum("8")
    fun button_9() = inputNum("9")
    fun button_0() = inputNum("0")
    fun button_point() = inputNum(".")
}