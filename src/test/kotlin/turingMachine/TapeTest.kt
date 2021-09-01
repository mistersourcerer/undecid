package turingMachine

import kotlin.test.Test
import kotlin.test.assertEquals

class TapeTest {
    @Test
    fun tapeWithDefaultValues() {
        val tape = Tape()
        assertEquals(Char.MIN_VALUE, tape.value())
    }

    @Test
    fun tapeWithInitialValues() {
        val tape = Tape('0')
        assertEquals('0', tape.value())
    }

    @Test
    fun defaultTapeWhenNoValuesGiven() {
        val tape = Tape('0')
        assertEquals('0', tape.value())
        assertEquals('0', tape.left().value())
        assertEquals('0', tape.right().value())
    }

    @Test
    fun moveBeltLeft() {
        val tape = Tape(values = listOf('0', '1', '2')).left()
        assertEquals('0', tape.value())
    }

    @Test
    fun moveBeltRight() {
        val tape = Tape(values = listOf('0', '1', '2')).right()
        assertEquals('2', tape.value())
    }

    @Test
    fun generateNewCellsWhenTapeEndsMovingLeft() {
        val tape = Tape(values = listOf('1'), default = '0').left()
        assertEquals('0', tape.value())
    }

    @Test
    fun generateNewCellsWhenTapeEndsMovingRight() {
        val tape = Tape(values = listOf('1'), default = '0').right()
        assertEquals('0', tape.value())
    }

    @Test
    fun writeIntoCurrentCell() {
        val tape = Tape('0').write('1')
        assertEquals('1', tape.value())
    }

    fun testResetForCreatingTapesOnMostLeftPosition() {
        val tape = Tape(values = listOf('a', 'b', 'c', 'd')).reset()
        assertEquals('a', tape.value())
    }
}