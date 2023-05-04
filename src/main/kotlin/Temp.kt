import java.util.*

object PermutationStep {
    fun permutationStep(num: Int): Int {
        val numStr = num.toString()
        val perms = getPermutations(
            "",
            numStr, ArrayList()
        )
        Collections.sort(perms)
        perms.sort()
        val numIndex = perms.indexOf(num)
        if (numIndex == perms.size - 1) {
            return -1
        }
        for (i in numIndex until perms.size) {
            if (perms[i] != num) {
                return perms[i]
            }
        }
        return -1
    }

    private fun getPermutations(
        begStr: String,
        endStr: String, perms: MutableList<Int>
    ): MutableList<Int> {
        if (endStr.length <= 1) {
            perms.add((begStr + endStr).toInt())
        } else {
            for (i in endStr.indices) {
                val newString = (endStr.substring(0, i)
                        + endStr.substring(i + 1))
                getPermutations(begStr + endStr[i], newString, perms)
            }
        }
        return perms
    }
}


fun main() {
    // keep this function call here
    print(PermutationStep.permutationStep(41352))
}