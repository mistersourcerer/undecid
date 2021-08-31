package turingMachine

import turingMachine.Belt
import kotlin.test.Test
import kotlin.test.assertEquals

class BeltTest {
    @Test
    fun tapeWithDefaultValues() {
        val belt = Belt()
        assertEquals(Char.MIN_VALUE, belt.value())
    }

    @Test
    fun tapeWithInitialValues() {
        val belt = Belt('0')
        assertEquals('0', belt.value())
    }

    @Test
    fun defaultTapeWhenNoValuesGiven() {
        val belt = Belt('0')
        assertEquals('0', belt.value())
        assertEquals('0', belt.left().value())
        assertEquals('0', belt.right().value())
    }

    @Test
    fun moveBeltLeft() {
        val belt = Belt(values = listOf('0', '1', '2')).left()
        assertEquals('0', belt.value())
    }

    @Test
    fun moveBeltRight() {
        val belt = Belt(values = listOf('0', '1', '2')).right()
        assertEquals('2', belt.value())
    }

    @Test
    fun generateNewCellsWhenTapeEndsMovingLeft() {
        val belt = Belt(values = listOf('1'), default = '0').left()
        assertEquals('0', belt.value())
    }

    @Test
    fun generateNewCellsWhenTapeEndsMovingRight() {
        val belt = Belt(values = listOf('1'), default = '0').right()
        assertEquals('0', belt.value())
    }

    @Test
    fun writeIntoCurrentCell() {
        val belt = Belt('0').write('1')
        assertEquals('1', belt.value())
    }
}