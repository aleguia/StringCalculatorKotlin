/*
* Created by Fernando Leguia on May 11, 2022
*/
object Calculator {
    fun add(numbers: String): Int {

        var sanitizedNumbers = handleNewLines(numbers)
        if (sanitizedNumbers.isEmpty()) return 0

        var delimiter = ","
        val regex = "(/{2}.)(.*)".toRegex()

        if (regex.containsMatchIn(sanitizedNumbers)){
            val (delimiterGroup, numbersGroup) = regex.find(sanitizedNumbers)!!.destructured
            sanitizedNumbers = numbersGroup
            delimiter = extractDelimiter(delimiterGroup)
        }

        val numbersList = sanitizedNumbers.split(delimiter)
            .map { stringNumber -> Integer.parseInt(stringNumber) }

        return numbersList.sum()
    }

    private fun extractDelimiter(text: String): String{
        return text.substring(2)
    }

    private fun handleNewLines(text: String): String {
        return text.replace("\n", "")
    }
}

fun main(args: Array<String>){
    //Step 1 examples
    var input = "1,2,5"
    println("Input: $input Result: ${Calculator.add(input)}")

    // Step 2 examples
    input = "1\n,2,3"
    println("Input: $input Result: ${Calculator.add(input)}")

    input = "1,\n2,4"
    println("Input: $input Result: ${Calculator.add(input)}")

    //Step 3 examples

    input = "//;\n1;3;4"
    println("Input: $input Result: ${Calculator.add(input)}")

    input = "//$\n1$2$3"
    println("Input: $input Result: ${Calculator.add(input)}")

    input = "//@\n2@3@8"
    println("Input: $input Result: ${Calculator.add(input)}")
}