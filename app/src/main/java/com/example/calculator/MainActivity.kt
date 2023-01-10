package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = "0"
        }

        button_openBracket.setOnClickListener {
            input.text = addTextToInput("(")
        }

        button_closeBracket.setOnClickListener {
            input.text = addTextToInput(")")
        }

        button_0.setOnClickListener {
            input.text = addTextToInput("0")
        }

        button_1.setOnClickListener {
            input.text = addTextToInput("1")
        }

        button_2.setOnClickListener {
            input.text = addTextToInput("2")
        }

        button_3.setOnClickListener {
            input.text = addTextToInput("3")
        }

        button_4.setOnClickListener {
            input.text = addTextToInput("4")
        }

        button_5.setOnClickListener {
            input.text = addTextToInput("5")
        }

        button_6.setOnClickListener {
            input.text = addTextToInput("6")
        }

        button_7.setOnClickListener {
            input.text = addTextToInput("7")
        }

        button_8.setOnClickListener {
            input.text = addTextToInput("8")
        }

        button_9.setOnClickListener {
            input.text = addTextToInput("9")
        }

        button_divide.setOnClickListener {
            input.text = addTextToInput("/")
        }

        button_multiply.setOnClickListener {
            input.text = addTextToInput("*")
        }

        button_plus.setOnClickListener {
            input.text = addTextToInput("+")
        }

        button_minus.setOnClickListener {
            input.text = addTextToInput("-")
        }

        button_dot.setOnClickListener {
            input.text = addTextToInput(".")
        }

        button_equal.setOnClickListener {
            showResult()
        }
    }

    private fun addTextToInput(buttonValue: String): String {
        return "${input.text}$buttonValue";
    }

    private fun getInputExpression(): String {
        var expression: String = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("x"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()

            if(result.isNaN()) {
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
                // Show error message
            }
            else {
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }
        catch (e: Exception) {
            println(e);
        }
    }
}