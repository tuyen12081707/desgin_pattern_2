package com.example.myapplication.beheivior

import com.example.myapplication.beheivior.StrategyDesginPattern.BubbleSortStrategy
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith


open class StrategyDesginPattern {
    interface SortStrategy {
        fun <T : Comparable<T>> sort(list: MutableList<T>)
    }

    class BubbleSortStrategy : SortStrategy {
        override fun <T : Comparable<T>> sort(list: MutableList<T>) {
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
            println("Bubble Sort: $list")
        }
    }

    class MergeSortStrategy : SortStrategy {
        override fun <T : Comparable<T>> sort(list: MutableList<T>) {
            list.forEach {
                print(it.toString() + " |")
            }
            println("")
            println("Merge Sort")
            println("==========")
        }
    }
    class QuickSortStrategy : SortStrategy {
        override fun <T : Comparable<T>> sort(list: MutableList<T>) {
            quickSort(list, 0, list.size - 1)
            println("Quick Sort: $list")
        }

        private fun <T : Comparable<T>> quickSort(list: MutableList<T>, low: Int, high: Int) {
            if (low < high) {
                val pivotIndex = partition(list, low, high)
                quickSort(list, low, pivotIndex - 1)
                quickSort(list, pivotIndex + 1, high)
            }
        }

        private fun <T : Comparable<T>> partition(list: MutableList<T>, low: Int, high: Int): Int {
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
    }

    //context
    class Sorter(private var strategy: SortStrategy) {
        fun <T : Comparable<T>> sort(list: MutableList<T>) {
            strategy.sort(list)
        }

        fun setStrategy(newStrategy: SortStrategy) {
            strategy = newStrategy
        }
    }
    @Test
    fun testStrategy() {
        val sortContext = Sorter(BubbleSortStrategy())
        sortContext.sort(mutableListOf(5, 2, 6, 1, 10))
        sortContext.setStrategy(QuickSortStrategy())
        sortContext.sort(mutableListOf(8, 6, 1, 3, 5))
        sortContext.setStrategy(MergeSortStrategy())
        sortContext.sort(mutableListOf(123, 123, 34, 54, 12))
    }

}

