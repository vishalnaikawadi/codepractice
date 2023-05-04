fun main() {

    val operation1 = (1..10)
        .filter { it % 2 == 1 } // 1, 3, 5, 7, 9
        .map { it * 2 }        // 2, 6, 10, 14, 18
        .take(2)               // 2, 6

    val operation2 = (1..10).asSequence()
        .filter { it % 2 == 1 }
        .map { it * 2 }
        .take(2)
        .toList()

    val seq = generateSequence(0) { it + 1 }
        .filter { it % 2 == 0 }
        .map { it * 3 }
        .take(100)
        .average()

    println("sequence is: $seq")

    var a = 100
    var b = 200

//    a += b
//    b = a - b
//    a -= b

    a = a swap b
    b = b swap a
    println("$a , $b")

    println()
    println(pairEg())
    println(tripleEg())
    println(percentage(230F, 400F))

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val (odd, even) = list.partition { it % 2 == 1 }

    println("even: $even , odd: $odd")

}

// obtained/total * 100
// 2 pie r * r

infix fun Int.swap(num: Int) = (this + num) - this

infix fun Int.addMe(a: Int) = (this + a)


val map = 1 to "A" to "C"

val triple: Triple<String, Int, Boolean> = Triple("John", 26, true)

fun pairEg() = println("$map:: ${map.first}, ${map.second}, ${map.first.first}")
fun tripleEg() = println("$triple:: ${triple.first}, ${triple.second}, ${triple.third}")

val percentage: (Float, Float) -> Float = { i, j -> (i / j) * 100 }

var ttttt: Int = 0
var ttt: Number = ttttt


/**
 * Fragment lifecycle
 *
 * onAttach()
 * onCreate()
 * onCreateView()
 * onViewCreated()
 * onStart()
 * onResume()
 *
 * onPause()
 * onStop()
 * onDestroyView()
 * onDestroy()
 * onDetach()
 */