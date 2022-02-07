package pimienta.julian.asignacion4_calculadoraimc_pimienta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var IMC : Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnCalcular : Button = findViewById(R.id.btnCalcular) as Button
        var imc : TextView = findViewById(R.id.imc) as TextView
        var range : TextView = findViewById(R.id.range) as TextView

                btnCalcular.setOnClickListener {
            imc.setText(calcularIMC().toString())

                    if(IMC < 18.5){
                       range.setText("Bajo peso")
                       range.setBackgroundResource(R.color.colorGreenish)
                    }else if (IMC in 18.5..24.9){
                        range.setText("Normal")
                        range.setBackgroundResource(R.color.colorGreen)
                    }else if (IMC in 25.0..29.9){
                        range.setText("Sobrepeso")
                        range.setBackgroundResource(R.color.colorYellow)
                    } else if (IMC in 30.0..34.9){
                        range.setText("Obesidad grado 1")
                        range.setBackgroundResource(R.color.colorOrange)
                    }else if (IMC in 35.0..39.9){
                        range.setText("Obesidad grado 2")
                        range.setBackgroundResource(R.color.colorRed)
                    }else if (IMC >= 40.0){
                        range.setText("Obesidad grado 3")
                        range.setBackgroundResource(R.color.colorBrown)
                    }else{
                        range.setText("F en el chat")
                        range.setBackgroundColor(Color.GRAY)
                    }


        }


    }


    fun calcularIMC(): Float{
        var weight: EditText = findViewById(R.id.weight) as EditText
        var height: EditText = findViewById(R.id.height) as EditText
        IMC = (weight.text.toString().toFloat()) / (height.text.toString().toFloat() * height.text.toString().toFloat())
        return IMC
    }
}