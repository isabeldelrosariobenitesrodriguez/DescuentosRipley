package com.example.descuentosripley

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val textViewIgv = findViewById<TextView>(R.id.textViewIgv)
        val textViewMontoSinDescuento = findViewById<TextView>(R.id.textViewMontoSinDescuento)
        val textViewPorcentajeDescuento = findViewById<TextView>(R.id.textViewPorcentajeDescuento)
        val textViewMontoConDescuento = findViewById<TextView>(R.id.textViewMontoConDescuento)

        val categorias = arrayOf("Zapatos", "Prendas para dama", "Electrodomésticos", "Celulares", "Ropa para caballero", "Juguetes para niños", "Laptops")
        val descuentos = arrayOf(10, 18, 7, 9, 5, 13, 19)
        val montosMinimos = arrayOf(1000, 500, 6000, 3500, 1500, 2500, 8000)

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categorias)

        button.setOnClickListener {
            val monto = editText.text.toString().toDouble()
            val categoria = spinner.selectedItemPosition

            val descuentoPorcentaje = if (monto > montosMinimos[categoria]) descuentos[categoria] else 0
            val descuento = monto * descuentoPorcentaje / 100
            val igv = (monto - descuento) * 0.18
            val montosinDescuento = monto + igv
            val montoConDescuento = montosinDescuento  - descuento

            textViewIgv.text = String.format("%.2f", igv)
            textViewMontoSinDescuento.text = String.format("%.2f", montosinDescuento)
            textViewPorcentajeDescuento.text = "${descuentoPorcentaje}%"
            textViewMontoConDescuento.text = String.format("%.2f", montoConDescuento)
        }

    }
}
