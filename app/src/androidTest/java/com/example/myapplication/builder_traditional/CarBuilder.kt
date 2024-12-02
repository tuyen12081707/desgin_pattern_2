package com.example.myapplication.builder_traditional

import com.example.myapplication.CarKotlin
import org.junit.Assert
import org.junit.Test

class CarBuilder :IBuilderCar {
    private var brand: String? = null
    private var color: String? = null
    private var model: String? = null
    private var engine: String? = null
    private var transmission: String? = null
    override fun setBrand(brand: String): IBuilderCar {
        this.brand = brand
        return this
    }

    override fun setColor(color: String): IBuilderCar {
        this.color = color
        return this
    }

    override fun setModel(model: String): IBuilderCar {
        this.model = model
        return this
    }

    override fun setEngine(engine: String): IBuilderCar {
        this.engine = engine
        return this
    }

    override fun setTransmission(transmission: String): IBuilderCar {
        this.transmission = transmission
        return this
    }

    override fun build(): Car {
        return Car(brand, color, model, engine, transmission)
    }
}

class CarTest {
    @Test
    fun builderTest2() {
        val car = CarBuilder()
            .setBrand("Toyota2")
            .setColor("Red")
            .setEngine("2.0L")
            .setTransmission("Automatic")
            .build()
        println(car.toString())
    }

}