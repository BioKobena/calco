package fr.istic.mob.calculatrice

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var textInput : EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textInput = findViewById(R.id.ecran)
        textInput.showSoftInputOnFocus = false

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.trois)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun numberClick(view: View?) {
        val buttonText = (view as? android.widget.Button)?.text?.toString() ?: return
        val currentText = textInput.text.toString()
        val selectionStart = textInput.selectionStart.coerceAtLeast(0)
        val newText = StringBuilder(currentText).insert(selectionStart, buttonText).toString()
        textInput.setText(newText)
        textInput.setSelection(selectionStart + buttonText.length) // Permet de mettre le curseur à droite @Bio Kobena
    }


    fun operationClick(view: View?) { val buttonText = (view as? android.widget.Button)?.text?.toString() ?: return
        val currentText = textInput.text.toString()
        val selectionStart = textInput.selectionStart.coerceAtLeast(0)
        val newOperation = StringBuilder(currentText).insert(selectionStart, buttonText).toString()
        textInput.setText(newOperation)
        textInput.setSelection(selectionStart + buttonText.length) // Permet de mettre le curseur à droite @Bio Kobena


    }

    fun resetClick(view: View?){
        println("AC");
    }

    fun eraseClick(view: View?) {
        val text = textInput.text.toString()
        val cursorPos = textInput.selectionStart

        if (cursorPos > 0) {
            val newText = StringBuilder(text).deleteCharAt(cursorPos - 1).toString()
            textInput.setText(newText)
            textInput.setSelection(cursorPos - 1)
        }
    }

    fun moinsClick(view: View?){
        println("-");
    }
    fun plusClick(view: View?){
        println("+");
    }
    fun diviseClick(view: View?){
        println("/");
    }
    fun mutipleClick(view: View?){
        println("x");
    }
    fun equalClick(view: View?){
        println("=");
    }
}