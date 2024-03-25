import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GameTest {

    private lateinit var game: Game
    private val playerA: Player = mock()
    private val playerB: Player = mock()

    @BeforeEach
    fun setUp() {
        game = Game(playerA, playerB)
    }


    @Test
    fun playRounds_whenPlayerA_IsWin() {
        // Mock player moves
        whenever(playerA.play()).thenReturn(Move.ROCK)
        whenever(playerB.play()).thenReturn(Move.SCISSORS)

        val game = Game(playerA,playerB)
        game.playRounds(1)

        // Assertions
        assertEquals(1, game.playerAWins)
        assertEquals(0, game.playerBWins)
        assertEquals(0, game.draws)
    }

    @Test
    fun playRounds_whenPlayerB_IsWin() {
        // Mock player moves
        whenever(playerA.play()).thenReturn(Move.SCISSORS)
        whenever(playerB.play()).thenReturn(Move.ROCK)

        val game = Game(playerA,playerB)
        game.playRounds(1)

        // Assertions
        assertEquals(0, game.playerAWins)
        assertEquals(1, game.playerBWins)
        assertEquals(0, game.draws)
    }

    @Test
    fun playRounds_whenPlayerA_and_playerB_draws() {
        // Mock player moves
        whenever(playerA.play()).thenReturn(Move.ROCK)
        whenever(playerB.play()).thenReturn(Move.ROCK)

        val game = Game(playerA,playerB)
        game.playRounds(1)

        // Assertions
        assertEquals(0, game.playerAWins)
        assertEquals(0, game.playerBWins)
        assertEquals(1, game.draws)
    }

}