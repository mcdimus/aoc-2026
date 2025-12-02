import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.truncate

class Day02 : AbstractDay<List<ClosedRange<Double>>, Double>() {

    override fun transform(input: List<String>): List<ClosedRange<Double>> {
        return input[0].split(",").map(::toRange)
    }

    private fun toRange(it: String) =
        it.split("-").let { (start, end) -> start.toDouble()..end.toDouble() }

    override fun part1(input: List<ClosedRange<Double>>): Double {
        val invalidIDs = arrayListOf<Double>()
        for (range in input) {
            var cur = range.start
            while (cur <= range.endInclusive) {
                val digits = if (cur == 0.0) 1 else log10(cur).toInt() + 1
                if (digits % 2 == 1) {
                    cur = 10.0.pow(digits)
                    continue
                }
                val left = (cur / (10.0.pow(digits / 2))).toInt()
                val right = (cur % (10.0.pow(digits / 2))).toInt()
                if (left == right) {
                    invalidIDs.add(cur)
                    cur = (left + 1) * (10.0.pow(digits / 2)) + (left + 1)
                    continue
                }
                cur = (left) * (10.0.pow(digits / 2)) + (left)
                if (cur < range.start) {
                    cur = (left + 1) * (10.0.pow(digits / 2)) + (left + 1)
                }

            }
        }
        return invalidIDs.sum()
    }

    override fun part2(input: List<ClosedRange<Double>>): Double {
        val invalidIDs = arrayListOf<Double>()
        for (range in input) {
            var cur = range.start
            while (cur <= range.endInclusive) {
                val digits = if (cur == 0.0) 1 else log10(cur).toInt() + 1
                var len = 1
                while (len <= digits/2) {
                    val split = split(cur, len)
                    if (split.size == 1) {
                        invalidIDs.add(cur)
                        break
                    } else {
                        len++
                    }
                }
                cur++
            }
        }
        return invalidIDs.sum()
    }

}

private fun split(value: Double, len: Int): Set<Double> {
    val digits = if (value == 0.0) 1 else log10(value).toInt() + 1
    if (digits - (digits/ len)*len !=0) {
        return setOf()
    }
    val result = hashSetOf<Double>()
    val a = 10.0.pow(len)
    var cur = value
    while (true) {
        result.add((cur) % a)
        cur = truncate( cur/a)
        if ( cur <1) {
            break
        }
    }
    return result
}

fun main() {
    Day02().run()
}