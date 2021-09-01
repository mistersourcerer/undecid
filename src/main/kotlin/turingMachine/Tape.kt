package turingMachine

class Tape(
    private val default: Char = Char.MIN_VALUE,
    private val values: List<Char> = listOf(default, default, default)
) {
    companion object private fun withIndex(
        newIndex: Int = index,
        valuesTransform: () -> List<Char> = { values }
    ): Tape {
        return Tape(values = valuesTransform()).apply { index = newIndex }
    }

    private var index = if (values.size > 1) 1 else 0

    fun value() = values[index]

    fun left(): Tape {
        return if (index <= 0) {
            withIndex { listOf(default) + values }
        }  else {
            withIndex(index - 1)
        }
    }

    fun right(): Tape {
        val newIndex = index + 1
        return if (values.size == newIndex) {
            withIndex(newIndex) { values.plus(default) }
        } else {
            withIndex(newIndex)
        }
    }

    fun reset() = withIndex(0)

    fun write(newValue: Char): Tape {
        return withIndex() {
            values.mapIndexed { i, c ->
                return@mapIndexed if (i == index) newValue else c
            }
        }
    }
}