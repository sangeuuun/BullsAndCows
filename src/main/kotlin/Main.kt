package org.example

fun main() {
    val n = "476"
    println("< 게임을 시작합니다 >")

    while (true) {
        try {
            println("숫자를 입력하세요")
            val input = readln().toInt()
            val num = input.toString()

            if (num.length != num.toSet().size || num.contains("0")) {
                throw NumberFormatException()
            }
            if (n == num) {
                println("정답입니다!")
                break
            }

            var strike = 0
            var ball = 0

            for (i in n.indices) {
                if (n[i] == num[i]) {
                    strike++
                }
            }

            for (i in n.indices) {
                for (j in num.indices) {
                    if (i != j && n[i] == num[j]) {
                        ball++
                    }
                }
            }

            if (strike == 0 && ball == 0) {
                println("Nothing")
                println("")
                continue
            }

            println("${strike}스트라이크 ${ball}볼")
            println("")


        } catch (e: NumberFormatException) {
            println("올바르지 않은 입력값입니다")
            println("")
            continue
        }
    }

}