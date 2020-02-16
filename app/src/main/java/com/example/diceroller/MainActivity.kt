package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    //Use the lateinit keyword for the field to avoid needing to declare it nullable.
    //var diceImage : ImageView? = null

    lateinit var diceImage: ImageView
    lateinit var diceImage1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var rollButton: Button = findViewById(R.id.roll_button);
        rollButton.setOnClickListener() { rollDice() }

        var resetButton: Button = findViewById(R.id.clear);
        resetButton.setOnClickListener() { reset() }
        diceImage = findViewById(R.id.dice_image);
        diceImage1 = findViewById(R.id.dice_image1);

        /* var countUpButton: Button = findViewById(R.id.roll_button1);
        countUpButton.setOnClickListener { countUp() }*/
    }

    fun rollDice() {

        //  Toast.makeText(this, "button-clicked", Toast.LENGTH_SHORT).show();
        diceImage.setImageResource(getRandomDiceImage())
        diceImage1.setImageResource(getRandomDiceImage())

    }


    fun getRandomDiceImage(): Int {

        val rndNum = Random().nextInt(6) + 1;
        return when (rndNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

    }

    fun getEmptyImage():Int{

        return R.drawable.empty_dice
    }

    fun reset() {

            diceImage1.setImageResource(getEmptyImage());
            diceImage.setImageResource(getEmptyImage());
        }

    /*fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text);
        if (resultText.text == "Hello World") {
            resultText.text == "1";
        } else {
            var resultInt = resultText.text.toString().toInt();
            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString();
            }
        }
    }*/

}