package luana.developerandroid.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. Create a reference to the button btnRolarDado
        val rolarDados: Button = findViewById(R.id.btnRolarDado)
        //Make a listener to the reference(button) so it runs the function rollDice()
        rolarDados.setOnClickListener { rollDice() }
    }
    // 3. Create a function where it will call the Dice and make a roll
    private fun rollDice() {
        //Creating a reference to Dice and specifying the number of sides
        val dice = Dice(6)
        //Making the Dice reference run the function inside of it
        val diceRoll = dice.roll()
        //Making a reference to the TextView
        val resultTextView: TextView = findViewById(R.id.diceNumberTextView)
        //Make this TextView reference show a text and convert the INT result from diceRoll to String
        resultTextView.text = diceRoll.toString()
    }


}
// 2. Make a class called Dice and a function to create a random number
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}