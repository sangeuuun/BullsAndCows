package org.example

class GameFunction {
    var gameHistory = mutableListOf<Int>()

    fun start() {
        while (true) {

            val selectMenu = getMenuNum()
            when (selectMenu) {
                "1" -> startGame()
                "2" -> viewGameHistory()
                "3" -> {
                    println("< 숫자 야구 게임을 종료합니다 >")
                    return
                }
                else -> println("올바른 숫자를 입력해주세요!\n")
            }
        }
    }
    fun getMenuNum():String {
        println("환영합니다! 원하시는 번호를 입력해주세요")
        println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기")

        val menuInput = readln()

        return menuInput
    }

    fun startGame() {
        var cnt = 0
        val answer = createAnswer().joinToString("")
        println("\n< 게임을 시작합니다 >")
        while (true) {
            try {
                println("숫자를 입력하세요")
                val input = readln()

                if (answer.length != input.toSet().size || input[0] == '0') {
                    throw NumberFormatException()
                }
                cnt++
                if (checkAnswer(answer, input)) break


            } catch (e: NumberFormatException) {
                println("올바르지 않은 입력값입니다\n")
                continue
            }
        }
        gameHistory.add(cnt)
    }

    fun createAnswer():MutableSet<Int> {
        val answer = mutableSetOf<Int>()

        while (answer.size < 3) {
            val random = (0..9).random()
            answer += random

            if (answer.toList()[0] == 0) {
                answer -= random
            }
        }
        return answer
    }

    fun checkAnswer(answer:String, input:String): Boolean {
        if (answer == input) {
            println("정답입니다!\n")
            return true
        }

        var strike = 0
        var ball = 0

        for (i in answer.indices) {
            for (j in input.indices) {
                if (answer[i] == input[j]) {
                    if (i == j) strike++
                    else ball++
                }
            }
        }

        if (strike == 0 && ball == 0) {
            println("Nothing\n")
            return false
        }

        println("${strike}스트라이크 ${ball}볼\n")
        return false

    }
    fun viewGameHistory() {
        println()
        println("\n< 게임 기록 보기 >")
        if (gameHistory.isEmpty()) println("게임 기록이 없습니다.")
        gameHistory.forEachIndexed { index, it -> println("${index+1}번째 게임 : 시도 횟수 - $it")}

    }

}