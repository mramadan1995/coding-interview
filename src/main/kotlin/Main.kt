
fun main() {

    val playerA = Player { Move.ROCK }
    val playerB = Player { Move.entries.toTypedArray().random() }
    val game = Game(playerA,playerB)
    game.playRounds(100)
}