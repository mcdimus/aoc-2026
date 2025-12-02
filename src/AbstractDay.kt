import kotlin.time.measureTime

abstract class AbstractDay<T, R> {

    protected abstract fun transform(input: List<String>): T

    protected abstract fun part1(input: T): R

    protected abstract fun part2(input: T): R

    fun run() {
        val testInput = readInput("${this::class.simpleName!!}_test")
        val input = readInput(this::class.simpleName!!)

        println("Part 1 ======================")
        println("Test: $testInput")
        println("Test answer: ${part1(transform(testInput))}")
        println("-----------------------------")
        print("Answer: ")
        val part1Duration = measureTime {
            val part1Answer = part1(transform(input))
            println("$part1Answer")
        }
        println("Time: $part1Duration")
        println("-----------------------------")

        println("Part 2 ======================")
        println("Test: $testInput")
        println("Test answer: ${part2(transform(testInput))}")
        println("-----------------------------")
        print("Answer: ")
        val part2Duration = measureTime {
            val part2Answer = part2(transform(input))
            println("$part2Answer")
        }
        println("Time: $part2Duration")
        println("-----------------------------")
    }

}