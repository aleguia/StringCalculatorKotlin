import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Calendar
import kotlin.test.assertFailsWith

/*
* Created by Fernando Leguia on May 11, 2022
*/
internal class CalculatorTest{

    @Test
    fun `Should return an Integer`() {
        assertEquals(Int::class.java, Calculator.add("")::class.java)
    }

    @Test
    fun `Should return 0 when empty string is passed`() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    fun `Should return number when only one number passed`(){
        assertEquals(4, Calculator.add("4"));
    }

    @Test
    fun `Should return sum of two numbers`(){
        assertEquals(7, Calculator.add("4,3"))
    }

    @Test
    fun `Should sum any number of numbers passed`(){
        assertEquals(20, Calculator.add("1,7,4,8"))
    }

    @Test
    fun `should manage new lines passed`(){
        assertEquals(6, Calculator.add("1\n,2,\n3"))
    }

    @Test
    fun `should return sum when only a new lines is passed`(){
        assertEquals(0, Calculator.add("\n"))
    }

    @Test
    fun `should handle custom delimiter`(){
        assertEquals(13, Calculator.add("//@\n2@3@8"))
    }

    @Test
    fun `should throw negatives not allowed error when negative numbers passed`(){
        assertThrows(Calculator.Error.NegativesNotAllowed::class.java, { Calculator.add("//@\n2@3@0@-2@8@-1") } )
    }

    @Test
    fun `should list the negative numbers when throw negatives not allowed`(){
        val exception = assertFailsWith<Calculator.Error.NegativesNotAllowed> (
            block = { Calculator.add("//@\n2@3@0@-2@8@-1")  }
        )
        assertEquals(exception.message, "Negatives not allowed: [-2, -1]")
    }

    @Test
    fun `should ignore numbers larger than 1000`(){
        assertEquals(0, Calculator.add("1001"))
    }

    @Test
    fun `Delimiters of arbitrary lenght are allowed`(){
        assertEquals(13, Calculator.add("//***\n2***3***8"))
    }
}