import kotlin.math.abs

class Day01 : AbstractDay<List<Int>, Int>() {

    override fun transform(input: List<String>) = input
        .map { it.replace("L", "-") }
        .map { it.replace("R", "") }
        .map { it.toInt() }

    override fun part1(input: List<Int>) =
        input.fold(50 to 0) { (sum, count), value ->
            val newSum = (sum + value) % 100
            val newCount = count + if (newSum == 0) 1 else 0
            newSum to newCount
        }.second

    override fun part2(input: List<Int>): Int {
        var counter = 0
        var currentSum = 50
        for (instruction in input) {
            currentSum += instruction
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

}

fun main() {
    Day01().run()
}
