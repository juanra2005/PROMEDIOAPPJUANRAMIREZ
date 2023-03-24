package com.example.estudiantemateria

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonPromedio:Button= findViewById(R.id.btncalcular)
        botonPromedio.setOnClickListener { calcularPromedio() }

    }

    private fun calcularPromedio() {

        val NombreIngresado:EditText = findViewById(R.id.idNombreText)
        val MateriaIngresado:EditText = findViewById(R.id.idNombreMateriaText)
        val Nota1Ingresado:EditText = findViewById(R.id.idMateria1Text)
        val Nota2Ingresado:EditText = findViewById(R.id.idMateria2Text)
        val Nota3Ingresado:EditText = findViewById(R.id.idMateria3Text)
        val campoResultado:TextView = findViewById(R.id.txtMensaje1)

        val nombre:String = NombreIngresado.text.toString()
        val materia:String = MateriaIngresado.text.toString()
        val nota1:Double = Nota1Ingresado.text.toString().toDouble()
        val nota2:Double = Nota2Ingresado.text.toString().toDouble()
        val nota3:Double = Nota3Ingresado.text.toString().toDouble()

        var promedio:Double=(nota1+nota2+nota3)/3

        var rst=""

        if (promedio>=3.5){
            rst=" Estudiante: $nombre Materia: $materia Nota 1: $nota1 Nota 2: $nota2 Nota 3: $nota3 " +
                    "Ganó con una nota de: $promedio"

        }else{
            rst=" Estudiante: $nombre Materia: $materia Nota 1: $nota1 Nota 2: $nota2 Nota 3: $nota3 " +
                    "Perdió con una nota de: $promedio"
        }

        campoResultado.text=rst

        //Mostrar en otra pantalla
        val intent = Intent(this,estudiantesmateriaresponse::class.java)

        val miBundle:Bundle = Bundle()
        miBundle.putString("Promedio",campoResultado!!.text.toString())

        intent.putExtras(miBundle)
        startActivity(intent)
        }
    }