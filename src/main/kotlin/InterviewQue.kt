import java.util.*


fun countWays(n: Int, k: Int): Long {

    val dp = LongArray(n + 1)
    Arrays.fill(dp, 0)
    val mod = 1000000007

    dp[1] = k.toLong()

    var same = 0
    var diff = k


    for (i in 2..n) {

        same = diff


        diff = (dp[i - 1] * (k - 1)).toInt()
        diff %= mod

        // Total choices till i.
        dp[i] = ((same + diff) % mod).toLong()
    }
    return dp[n]
}


fun main() {
    val arr = intArrayOf(2, 65, 34, 2, 1, 7, 8)
    arr.sort()
    print(arr.contentToString())
}


