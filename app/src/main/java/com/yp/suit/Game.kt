package com.yp.suit

import kotlin.random.Random
import kotlin.random.nextInt

object Game {

    private val options = listOf("PAPER", "ROCK", "SCISSORS")

    private val rules = mapOf(
        "PAPER-ROCK" to true,
        "PAPER-SCISSORS" to false,
        "ROCK-SCISSORS" to true,
        "ROCK-PAPER" to false,
        "SCISSORS-PAPER" to true,
        "SCISSORS-ROCK" to false,
    )

    private val suitDrawble = mapOf(
        "PAPER" to R.drawable.paper,
        "ROCK" to R.drawable.rock,
        "SCISSORS" to R.drawable.scissors
    )

    fun pickRandomComputer(): String{
        return options[Random.nextInt(0, 3)]
    }

    fun pickDrawable(option : String): Int{
        return suitDrawble[option]!!
    }

    fun isDraw(option: String, computer: String): Boolean{
        return option == computer
    }

    fun isWin(option: String, computer: String): Boolean{
        return rules["$option-$computer"]!!
    }

}