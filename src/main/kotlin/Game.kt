class Game (private val playerA: Player, private val playerB: Player) {

     var playerAWins = 0
     var playerBWins = 0
     var draws = 0


    fun playRounds(rounds: Int) {
        repeat(rounds) {
            play()
        }
        println("Player A wins $playerAWins of 100 games")
        println("Player B wins $playerBWins of 100 games")
        println("Draws: $draws of 100 games")
    }

    private fun play() {
        when (calculateResult(playerA.play(), playerB.play())) {
            Result.WIN -> playerAWins++
            Result.LOSE -> playerBWins++
            Result.DRAW -> draws++
        }
    }

    private fun calculateResult(playerAMove: Move, playerBMove: Move): Result {
        if (playerAMove == playerBMove) return Result.DRAW
        return when (playerAMove) {
            Move.ROCK -> if (playerBMove == Move.SCISSORS) Result.WIN else Result.LOSE
            Move.PAPER -> if (playerBMove == Move.ROCK) Result.WIN else Result.LOSE
            Move.SCISSORS -> if (playerBMove == Move.PAPER) Result.WIN else Result.LOSE
        }
    }


}