/*
* Created by Fernando Leguia on May 11, 2022
*/
object Calculator {
    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0


        val numbersList = numbers.split(',')
            .map { stringNumber -> Integer.parseInt(stringNumber) }

        return numbersList.sum()
    }
}

fun main(args: Array<String>){
    val input = "1,2,5"
    println("Input: $input Result: ${Calculator.add(input)}")
}