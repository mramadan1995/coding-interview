import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class PlayerTest {

    @Test
    fun `play executes strategy and returns expected move`() {
        // Arrange
        val expectedMove = Move.ROCK // Assuming Move is a class or enum, replace with actual creation logic

        val strategyMock: () -> Move = mock() // Mocking the strategy lambda

        whenever(strategyMock.invoke()).thenReturn(expectedMove) // Configure the mock to return the expected Move

        val player = Player(strategyMock) // Injecting the mock strategy into the player

        // Act
        val actualMove = player.play()

        // Assert
        assertEquals(expectedMove, actualMove)
    }
}