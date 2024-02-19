package Chapter2.Greedy_Algorithm

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ExtensionTest {

    @Test
    fun isBorder() {
        // given
        val timeTable: MutableList<Pair<Int, Int>> = mutableListOf(1 to 3, 5 to 9)
        val time: Pair<Int, Int> = 3 to 5

        // when
        val expect = true
        val actual = !time.isReservation(timeTable)

        // then
        assertEquals(expect, actual)
    }

    @Test
    fun isOverlap() {
        // given
        val timeTable: MutableList<Pair<Int, Int>> = mutableListOf(1 to 6, 5 to 9)
        val time: Pair<Int, Int> = 3 to 5

        // when
        val expect = true
        val actual = time.isReservation(timeTable)

        // then
        assertEquals(expect, actual)
    }

    @Test
    fun isOverlap2() {
        // given
        val timeTable: MutableList<Pair<Int, Int>> = mutableListOf(3 to 5, 8 to 11)
        val time: Pair<Int, Int> = 8 to 12

        // when
        val expect = true
        val actual = time.isReservation(timeTable)

        // then
        assertEquals(expect, actual)
    }

    @Test
    fun isNotOverlap() {
        // given
        val timeTable: MutableList<Pair<Int, Int>> = mutableListOf(1 to 2, 7 to 9)
        val time: Pair<Int, Int> = 3 to 5

        // when
        val expect = false
        val actual = time.isReservation(timeTable)

        // then
        assertEquals(expect, actual)
    }
}
