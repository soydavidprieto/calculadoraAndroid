package com.example.calculadoraandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    private lateinit var operacion: TextView
    private lateinit var vistaResultado: TextView

    private var entradaActual = StringBuilder()
    private var ultimaOperacion = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        operacion = findViewById(R.id.operation)
        vistaResultado = findViewById(R.id.result)

        val botonesNumeros = arrayOf(R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.dot)
        for (idBoton in botonesNumeros) {
            findViewById<Button>(idBoton).setOnClickListener { recepcionarNumero(it) }
        }

        val botonesOperaciones = arrayOf(R.id.plus, R.id.rest, R.id.multiplication, R.id.division)
        for (idBoton in botonesOperaciones) {
            findViewById<Button>(idBoton).setOnClickListener { realizarOperacion(it) }
        }

        findViewById<Button>(R.id.equal).setOnClickListener { botonIgual() }

        findViewById<Button>(R.id.clean).setOnClickListener { limpiarCampos() }
    }

    private fun recepcionarNumero(vista: View) {
        val numero = (vista as Button).text.toString()
        entradaActual.append(numero)
        ultimaOperacion = false
        actualizarOperacion()
    }

    private fun realizarOperacion(vista: View) {
        val operacion = (vista as Button).text.toString()
        if (entradaActual.isNotEmpty() && !ultimaOperacion) {
            entradaActual.append(" $operacion ")
            ultimaOperacion = true
            actualizarOperacion()
        }
    }

}
