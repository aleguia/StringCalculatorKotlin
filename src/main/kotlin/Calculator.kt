/*
* Created by Fernando Leguia on May 11, 2022
*/
object Calculator {
    fun add(numbers: String): Int {

        var sanitizedNumbers = handleNewLines(numbers)
        if (sanitizedNumbers.isEmpty()) return 0

        var delimiter = ","
        val regex = "(/{2}.*)(\\n{1}.*)".toRegex()

        if (regex.containsMatchIn(numbers)) {
            val (delimiterGroup, numbersGroup) = regex.find(numbers)!!.destructured
            sanitizedNumbers = handleNewLines(numbersGroup)
            delimiter = extractDelimiter(handleNewLines(delimiterGroup))
        }

        val negativeNumbersList = sanitizedNumbers.split(delimiter).filter { Integer.parseInt(it) < 0 }

        if(negativeNumbersList.isNotEmpty()){
            throw Error.NegativesNotAllowed(negativeNumbersList)
        }

        val numbersList: List<Int> = sanitizedNumbers.split(delimiter).map {
            if(Integer.parseInt(it) <=1000) {
                Integer.parseInt(it)
            } else {
                0
            }
        }
        return numbersList.sum()
    }

    private fun extractDelimiter(text: String): String {
        return text.substring(2)
    }

    private fun handleNewLines(text: String): String {
        return text.replace("\n", "")
    }

    sealed class Error(override val message: String): Exception() {
        class NegativesNotAllowed(numbers: List<String>): Error("Negatives not allowed: $numbers")
    }
}

fun main(args: Array<String>) {
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

    //Step  4 examples
    try {
        input = "//@\n2@3@0@-2@8@-1"
        println("Input: $input Result: ${Calculator.add(input)}")
    }catch (ex: Exception){
        println(ex.message)
    }

    try {
        input = "//;\n1;-3;4"
        println("Input: $input Result: ${Calculator.add(input)}")
    }catch (ex: Exception){
        println(ex.message)
    }

    //Bonus examples

    input = "//@\n2@3@8@10@1000@1001"
    println("Input: $input Result: ${Calculator.add(input)}")

}