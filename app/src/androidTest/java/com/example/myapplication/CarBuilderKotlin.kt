package com.example.myapplication

import org.junit.Assert
import org.junit.Test

class CarKotlin private constructor(builder: Builder) {
     var brand: String? = null
     var color: String? = null
    private var model: String? = null
    private var engine: String? = null
    private var transmission: String? = null
    init {
        brand = builder.getBrand()
        color = builder.getColor()
        model = builder.getModel()
        engine = builder.getEngine()
        transmission = builder.getTransmission()
    }

    class Builder {
        private var brand: String? = null
        private var color: String? = null
        private var model: String? = null
        private var engine: String? = null
        private var transmission: String? = null
        fun setBrand(brand: String): Builder {
            this.brand = brand
            return this
        }


        fun setColor(color: String): Builder {
            this.color = color
            return this
        }

        fun setModel(model: String): Builder {
            this.model = model
            return this
        }

        fun setEngine(engine: String): Builder {
            this.engine = engine
            return this
        }

        fun setTransmission(transmission: String): Builder {
            this.transmission = transmission
            return this
        }

        fun build(): CarKotlin {
            return CarKotlin(this)
        }

        fun getBrand(): String? {
            return brand
        }

        fun getColor(): String? {
            return color
        }

        fun getModel(): String? {
            return model
        }

        fun getEngine(): String? {
            return engine
        }

        fun getTransmission(): String? {
            return transmission
        }
//        fun setBrand(brand: String): Builder = this.apply { this.brand = brand }
        }



    override fun toString(): String {
        return "brand: $brand, color: $color, model: $model, engine: $engine, transmission: $transmission"
    }


}

class CarTest {
    @Test
    fun builderTest() {
        val car = CarKotlin.Builder()
            .setBrand("Toyota")
            .setColor("Red")
            .setEngine("2.0L")
            .setTransmission("Automatic")
            .build()
        println(car.toString())
        Assert.assertEquals("Toyota", car.brand)

    }

}