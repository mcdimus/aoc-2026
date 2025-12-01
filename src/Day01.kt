import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0
        var currentSum = 50
        for (instruction in input) {
            if (instruction.startsWith("L")) {
                currentSum -= instruction.substring(1).toInt()
            }
            if (instruction.startsWith("R")) {
                currentSum += instruction.substring(1).toInt()
            }
            currentSum %= 100

            if (currentSum == 0) {
                counter++
            }
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        var currentSum = 50
        for (instruction in input) {
            if (instruction.startsWith("L")) {
                currentSum -= instruction.substring(1).toInt()
            }
            if (instruction.startsWith("R")) {
                currentSum += instruction.substring(1).toInt()
            }
            val fullTurns = abs(currentSum / 100)
            counter += fullTurns
            currentSum %= 100
            if (currentSum < 0) {
                counter++
                currentSum += 100
            }
        }

        return counter
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    println("testInput = ${testInput}")
    val part1 = part1(testInput)
    println("part1 = ${part1}")
    check(part1 == 3)
    val part2 = part2(testInput)
    println("part2 = ${part2}")
    check(part2 == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
