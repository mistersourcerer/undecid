package turingMachine

class Machine<T>(private val _tape: Tape) {
    private var tape = _tape.reset()

    fun read() =  tape.value()

    fun move(direction: String) {
        when (direction) {
            "R", "RIGHT", "r", "right" -> tape = tape.right()
            "L", "LEFT", "l", "left" -> tape = tape.left()
        }
    }
}
