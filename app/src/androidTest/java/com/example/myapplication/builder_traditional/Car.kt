package com.example.myapplication.builder_traditional

import com.example.myapplication.CarKotlin
import org.junit.Assert
import org.junit.Test

class Car() {
    private var brand: String? = null
    private var color: String? = null
    private var model: String? = null
    private var engine: String? = null
    private var transmission: String? = null

    override fun toString(): String {
        return "brand: $brand, color: $color, model: $model, engine: $engine, transmission: $transmission"
    }
    constructor(
        brand: String?,
        color: String?,
        model: String?,
        engine: String?,
        transmission: String?
    ) : this() {
        this.brand = brand
        this.color = color
        this.model = model
        this.engine = engine
        this.transmission = transmission
    }
    constructor(
        brand: String?,
    ) : this() {
        this.brand = brand
    }
    constructor(
        brand: String?,
        color: String?,
        model: String?,
    ) : this() {
        this.brand = brand
        this.color = color
        this.model = model
    }
}

class CarTestNormal{
    @Test
    fun builderTest() {
        val car =Car("Toyota 123", "Red123123", "2020123123123", "2.0L123123123", "Automatic123123")
        val car2 =Car("HonDa 123", "Green Apple", "2020123123123")
        val car3 =Car("Suzuki 123")
        println(car.toString())
        println(car2.toString())
        println(car3.toString())

    }
}
