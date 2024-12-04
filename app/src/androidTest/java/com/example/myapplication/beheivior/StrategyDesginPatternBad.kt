package com.example.myapplication.beheivior

import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith


open class StrategyDesginPatternBad {
    fun <T : Comparable<T>> bubbleSort(list: MutableList<T>) {
        val n = list.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (list[j] > list[j + 1]) {
                    val temp = list[j]
                    list[j] = list[j + 1]
                    list[j + 1] = temp
                }
            }
        }
        println("Sorted List (Bubble): $list")
    }
    // Merge Sort
    fun <T : Comparable<T>> mergeSort(list: MutableList<T>) {
        if (list.size <= 1) return

        val middle = list.size / 2
        val left = list.subList(0, middle).toMutableList()
        val right = list.subList(middle, list.size).toMutableList()

        mergeSort(left)
        mergeSort(right)

        merge(list, left, right)
        println("Sorted List (Merge): $list")
    }

    fun <T : Comparable<T>> merge(list: MutableList<T>, left: MutableList<T>, right: MutableList<T>) {
        var i = 0
        var j = 0
        var k = 0

        while (i < left.size && j < right.size) {
            if (left[i] <= right[j]) {
                list[k++] = left[i++]
            } else {
                list[k++] = right[j++]
            }
        }

        while (i < left.size) list[k++] = left[i++]
        while (j < right.size) list[k++] = right[j++]
    }

    // Quick Sort
    fun <T : Comparable<T>> quickSort(list: MutableList<T>) {
        println("quickSort")
    }

    fun <T : Comparable<T>> partition(list: MutableList<T>, low: Int, high: Int): Int {
        val pivot = list[high]
        var i = low - 1

        for (j in low until high) {
            if (list[j] <= pivot) {
                i++
                val temp = list[i]
                list[i] = list[j]
                list[j] = temp
            }
        }

        val temp = list[i + 1]
        list[i + 1] = list[high]
        list[high] = temp

        return i + 1
    }
    fun sort(list: MutableList<Int>, algorithm: String) {
        when (algorithm) {
            "bubble" -> bubbleSort(list)
            "merge" -> mergeSort(list)
            "quick" -> quickSort(list)
        }
    }
        @Test
        fun testStrategy2() {
            val list = mutableListOf(34, 7, 23, 32, 5, 62)
            sort(list,"bubble")

        }
}



