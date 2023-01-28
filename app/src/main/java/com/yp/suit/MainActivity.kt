package com.yp.suit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var paperImageButton: ImageButton
    lateinit var scissorsImageButton: ImageButton
    lateinit var rockImageButton: ImageButton
    lateinit var resultImageView: ImageView
    lateinit var resetButton: Button

    fun initComponents(){
        computerImageView = findViewById(R.id.computerImageView)
        paperImageButton = findViewById(R.id.paperImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        rockImageButton = findViewById(R.id.rockImageButton)
        resultImageView = findViewById(R.id.resultImageView)
        resetButton = findViewById(R.id.resetButton)
    }

    fun resetData(){
        resultImageView.setImageResource(R.drawable.question)
        computerImageView.setImageResource(R.drawable.question)
    }

    fun startGame(options: String){
        val computer = Game.pickRandomComputer()
        Log.i("Computer", computer)
        computerImageView.setImageResource(Game.pickDrawable(computer))

        when{
            Game.isDraw(options,computer) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(options,computer) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }

    }

    fun initListener(){
        paperImageButton.setOnClickListener { startGame("PAPER") }
        scissorsImageButton.setOnClickListener { startGame("SCISSORS") }
        rockImageButton.setOnClickListener { startGame("ROCK") }
        resetButton.setOnClickListener { resetData() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initListener()
    }
}