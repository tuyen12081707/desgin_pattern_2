package com.example.myapplication.bridge

interface Renderer {
    fun renderCircle(radius: Float)
    fun renderSquare(side: Float)
}
class ScreenRenderer : Renderer {
    override fun renderCircle(radius: Float) {
        println("Vẽ hình tròn trên màn hình với bán kính: $radius")
    }

    override fun renderSquare(side: Float) {
        println("Vẽ hình vuông trên màn hình với cạnh: $side")
    }
}
class PrinterRenderer : Renderer {
    override fun renderCircle(radius: Float) {
        println("In hình tròn với bán kính: $radius")
    }

    override fun renderSquare(side: Float) {
        println("In hình vuông với cạnh: $side")
    }
}
abstract class Shape2(protected val renderer: Renderer) {
    abstract fun draw()
}

class Circle(renderer: Renderer, private val radius: Float) : Shape2(renderer) {
    override fun draw() {
        renderer.renderCircle(radius)
    }
}

class Square(renderer: Renderer, private val side: Float) : Shape2(renderer) {
    override fun draw() {
        renderer.renderSquare(side)
    }
}

// Main function
fun main() {
    val screenRenderer = ScreenRenderer()
    val printerRenderer = PrinterRenderer()

    val circleOnScreen = Circle(screenRenderer, 10f)
    circleOnScreen.draw()
    val squareOnPrinter = Square(printerRenderer, 15f)
    squareOnPrinter.draw()
}
