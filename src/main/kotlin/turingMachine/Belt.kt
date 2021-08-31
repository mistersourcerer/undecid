package turingMachine

class Belt(
    private val default: Char = Char.MIN_VALUE,
    private val values: List<Char> = listOf(default, default, default)
) {
    companion object private fun withIndex(
        newIndex: Int = index,
        valuesTransform: () -> List<Char> = { values }
    ): Belt {
        return Belt(values = valuesTransform()).apply { index = newIndex }
    }

    private var index = if (values.size > 1) 1 else 0

    fun value() = values[index]

    fun left(): Belt {
        return if (index <= 0) {
            withIndex { listOf(default) + values }
        }  else {
            withIndex(index - 1)
        }
    }

    fun right(): Belt {
        val newIndex = index + 1
        return if (values.size == newIndex) {
            withIndex(newIndex) { values.plus(default) }
        } else {
            withIndex(newIndex)
        }
    }

    fun write(newValue: Char): Belt {
        return withIndex() {
            values.mapIndexed { i, c ->
                return@mapIndexed if (i == index) newValue else c
            }
        }
    }
}