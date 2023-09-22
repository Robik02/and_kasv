import java.io.File

val hangman = listOf("""
    ---------
    |       |
    |       o
    |      /|\
    |      / \
    |
    -------------
""".trimIndent(), """
    ---------
    |       |
    |       o
    |      /|\
    |      /
    |
    -------------
""".trimIndent(), """
    ---------
    |       |
    |       o
    |      /|\
    |
    |
    -------------
""".trimIndent(), """
    ---------
    |       |
    |       o
    |      /|
    |
    |
    -------------
""".trimIndent(), """
    ---------
    |       |
    |       o
    |      /
    |
    |
    -------------
""".trimIndent(), """
    ---------
    |       |
    |       o
    |
    |
    |
    -------------
""".trimIndent(), """
    ---------
    |       |
    |
    |
    |
    |
    -------------
""".trimIndent(), """

    |
    |
    |
    |
    |
    -------------
""".trimIndent(), """






    -------------
""".trimIndent(), """







""".trimIndent())

fun main() {
    val words = File("words.txt").readLines().random()
    var status = ".".repeat(words.length).toCharArray()
    var lives = hangman.lastIndex

    while (lives >= 0 && String(status) != words) {
        println(hangman[lives])
        println("Status: ${String(status)}")
        println("Lives: $lives")
        print("Guess: ")
        val guess = readLine()!!.trim().lowercase()

        if (guess.length == 1) {
            val letter = guess[0]
            if (words.contains(letter)) {
                for (i in words.indices) {
                    if (words[i] == letter) {
                        status[i] = letter
                    }
                }
            } else {
                lives--
            }
        } else if (guess == words) {
            println("Congratulations! You've guessed the word: $words")
            break
        } else {
            println("You entered more letters, which counts as an attempt to guess the whole word.")
            lives--
        }

        if (lives == 0) {
            println("The game is over! The word was: $words")
            break
        }
    }
}