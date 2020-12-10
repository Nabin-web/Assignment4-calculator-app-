package com.example.calculatorapp
import net.objecthunter.exp4j.ExpressionBuilder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView

private lateinit var tvScreen: TextView
private lateinit var btnAc: Button
private lateinit var btnPower: Button
private lateinit var btnDiv: Button
private lateinit var btnMul: Button
private lateinit var btnSeven: Button
private lateinit var btnEight: Button
private lateinit var btnNine: Button
private lateinit var btnAdd: Button
private lateinit var btnFour: Button
private lateinit var btnFive: Button
private lateinit var btnSix: Button
private lateinit var btnOne: Button
private lateinit var btnTwo: Button
private lateinit var btnThree: Button
private lateinit var btnSub: Button
private lateinit var btnPercent: Button
private lateinit var btnZero: Button
private lateinit var btnPoint: Button
private lateinit var btnEquals: Button
private lateinit var btnBracket: Button
 var bracketCheck : Boolean = true

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAc = findViewById(R.id.btnAc)
        btnPower= findViewById(R.id.btnPower)
        btnDiv = findViewById(R.id.btnDiv)
        btnMul = findViewById(R.id.btnMul)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnPercent = findViewById(R.id.btnPercent)
        btnEquals = findViewById(R.id.btnEqualsto)
        btnPoint = findViewById(R.id.btnPoint)
        btnBracket = findViewById(R.id.btnBracket)

        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)
        btnSix = findViewById(R.id.btnSix)
        btnFive = findViewById(R.id.btnFive)
        btnFour = findViewById(R.id.btnFour)
        btnThree = findViewById(R.id.btnThree)
        btnTwo = findViewById(R.id.btnTwo)
        btnOne = findViewById(R.id.btnOne)
        btnZero = findViewById(R.id.btnZero)
        tvScreen = findViewById(R.id.tvScreen)




        btnZero.setOnClickListener { appendOnClick(true, "0") }
        btnOne.setOnClickListener { appendOnClick(true, "1") }
        btnTwo.setOnClickListener { appendOnClick(true, "2") }
        btnThree.setOnClickListener { appendOnClick(true, "3") }
        btnFour.setOnClickListener { appendOnClick(true, "4") }
        btnFive.setOnClickListener { appendOnClick(true, "5") }
        btnSix.setOnClickListener { appendOnClick(true, "6") }
        btnSeven.setOnClickListener { appendOnClick(true, "7") }
        btnEight.setOnClickListener { appendOnClick(true, "8") }
        btnNine.setOnClickListener { appendOnClick(true, "9") }
        btnPoint.setOnClickListener { appendOnClick(true, ".") }


        //Operator Listeners
        btnAdd.setOnClickListener { appendOnClick(false, "+") }
        btnSub.setOnClickListener { appendOnClick(false, "-") }
        btnMul.setOnClickListener { appendOnClick(false, "*") }
        btnDiv.setOnClickListener { appendOnClick(false, "/") }
        btnPower.setOnClickListener{appendOnClick(false,"^")}
        btnBracket.setOnClickListener {
            if(bracketCheck)
            {
                appendOnClick(false, "(")
                bracketCheck = false
            }
            else{
                appendOnClick(false, ")")
                bracketCheck = true

            }


        }


        btnAc.setOnClickListener {
            clear()
        }

        btnEquals.setOnClickListener {
            calculate()
        }

    }


    private fun appendOnClick(clear: Boolean, string: String) {

        if (clear) {
            tvScreen.append(string)
        } else {
            tvScreen.append(string)


        }
    }

    private fun clear() {
       tvScreen.text = ""

    }

    private fun calculate() {

        try {

            val input = ExpressionBuilder(tvScreen.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()){
                tvScreen.text = longOutput.toString()
            }else{
                tvScreen.text = output.toString()
            }

        }catch (e:Exception){
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }


}