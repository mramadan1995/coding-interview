class Player(val strategy: () -> Move) {
    fun play(): Move = strategy()
}