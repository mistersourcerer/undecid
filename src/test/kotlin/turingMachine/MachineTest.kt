package turingMachine

import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MachineTest {
    enum class CHARS(val char: Char) {
        A('a'),
        B('b'),
        C('c'),
        D('d'),
        E('e'),
    }
    // a "weird" tape (in terms of values)
    // to make it easier to assert against positioning
    // and be sure where the head is

    private val tape = Tape(default = '-', values = CHARS.values().map { it.char })
    private var machine = Machine<CHARS>(tape)

    @AfterTest
    fun setup() {
        machine = Machine<CHARS>(tape)
    }

    @Test
    fun startAtTheMostLeftPosition() {
        assertEquals('a', machine.read())
    }

    @Test
    fun moveRightWithInstruction() {
        val result = listOf("r", "right", "R", "RIGHT").map {
            with(machine) {
                move(it)
                read()
            }
        }
        assertEquals(result, listOf('b', 'c', 'd', 'e'))
    }

    @Test
    fun moveLeftWithInstruction() {
        val result = listOf("l", "left", "L", "LEFT").map {
            with(machine) {
                move("r")
                move(it)
                read()
            }
        }
        assertEquals(result, listOf('a', 'a', 'a', 'a'))
    }
}