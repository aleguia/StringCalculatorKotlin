/*
* Created by Fernando Leguia on May 11, 2022
*/
object Calculator {
    fun add(numbers: String): Int {
        val sanitizedNumbers = handleNewLines(numbers)
        if (sanitizedNumbers.isEmpty()) return 0


        val numbersList = sanitizedNumbers.split(',')
            .map { stringNumber -> Integer.parseInt(stringNumber) }

        return numbersList.sum()
    }

    private fun handleNewLines(text: String): String{
        return text.replace("\n", "")
    }
}

fun main(args: Array<String>){
    var input = "1,2,5"
    println("Input: $input Result: ${Calculator.add(input)}")

    input = "1\n,2,3"
    println("Input: $input Result: ${Calculator.add(input)}")

    input = "1,\n2,4"
    println("Input: $input Result: ${Calculator.add(input)}")
}