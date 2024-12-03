package com.example.myapplication.bridge

import org.junit.Test

abstract class Shape {
    abstract fun draw()
}
//su dung ke thua
class CircleOnScreen(private val radius: Float) : Shape() {
    override fun draw() {
        println("Vẽ hình tròn trên màn hình với bán kính: $radius")
    }
}

class CircleOnPrinter(private val radius: Float) : Shape() {
    override fun draw() {
        println("In hình tròn với bán kính: $radius")
    }
}

class SquareOnScreen(private val side: Float) : Shape() {
    override fun draw() {
        println("Vẽ hình vuông trên màn hình với cạnh: $side")
    }
}

class SquareOnPrinter(private val side: Float) : Shape() {
    override fun draw() {
        println("In hình vuông với cạnh: $side")
    }
}
class test{
    @Test
    fun main() {
        val circleOnScreen = CircleOnScreen(10f)
      val circle=  circleOnScreen.draw()

        val squareOnPrinter = SquareOnPrinter(15f)
       val squre= squareOnPrinter.draw()


    }

}
