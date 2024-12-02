package com.example.myapplication.builder_traditional

interface IBuilderCar {
    fun setBrand(brand: String): IBuilderCar
    fun setColor(color: String): IBuilderCar
    fun setModel(model: String): IBuilderCar
    fun setEngine(engine: String): IBuilderCar
    fun setTransmission(transmission: String): IBuilderCar
    fun build():Car
}