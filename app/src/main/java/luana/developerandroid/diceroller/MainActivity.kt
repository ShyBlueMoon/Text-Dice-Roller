package luana.developerandroid.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.ImageView
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

        //Do a dice roll when the app starts so it doesn't show a blank image
        rollDice()
    }


    // 3. Create a function where it will call the Dice and make a roll
    private fun rollDice() {
        //Creating a reference to Dice and specifying the number of sides
        val dice = Dice(6)
        //Making the Dice reference run the actual roll dice
        val diceRoll = dice.roll()

        //Making a reference to the ImageView
        val diceImage:ImageView =findViewById(R.id.diceImageView)
        /** AO INVES DE ESCREVER REPETIDAS VEZES ISSO
         * when (diceRoll) {
        1 -> diceImage.setImageResource(R.drawable.dice_1)
        2 -> diceImage.setImageResource(R.drawable.dice_2)
        3 -> diceImage.setImageResource(R.drawable.dice_3)
        4 -> diceImage.setImageResource(R.drawable.dice_4)
        5 -> diceImage.setImageResource(R.drawable.dice_5)
        6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
         */


        //FAÇA ISSO: Make this ImageView reference show an image of the right side of the dice
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        //Make screen readers say the dice number out loud
        diceImage.contentDescription = diceRoll.toString()

    }


}
// 2. Make a class called Dice and a function to create a random number
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}