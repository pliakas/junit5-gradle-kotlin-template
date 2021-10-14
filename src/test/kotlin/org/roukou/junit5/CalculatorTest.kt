package org.roukou.junit5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @Nested
    @DisplayName("Calculator :: Addition Tests")
    class AdditionTests {
        @Test
        @Disabled
        @DisplayName("Simple Addition (ignored for demo reasons)")
        fun simpleAddition() {
            val calculator = Calculator()
            assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2")
        }

        @ParameterizedTest(name = "{0} + {1} = {2}")
        @CsvSource(
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
        )

        @DisplayName("Multiple additions")
        fun add(first: Int, second: Int, expectedResult: Int) {
            val calculator = Calculator()
            assertEquals(expectedResult, calculator.add(first, second)) {
                "$first + $second should equal $expectedResult"
            }
        }

        @Test
        @DisplayName("Failing test on puporse (for demo reasons")
        fun simpleFailedAddition() {
            val calculator = Calculator();
            assertEquals(3, calculator.add(2, 3), "2 + 3 should equal to 5")
        }
    }

    @Nested
    @DisplayName("Calculator :: Division Tests")
    class DivisionTests {
        @Test
        @DisplayName("Divide by zero")
        fun divisionByZeroError() {
            val calculator = Calculator()
            val exception = org.junit.jupiter.api.assertThrows<AssertionError> {
                calculator.div(1, 0)
            }
            assertEquals("Division by Zero", exception.message)
        }

    }

}
