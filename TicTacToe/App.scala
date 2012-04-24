class Board {
  val n = 3
  var board = Array.ofDim[Int](n, n)
  var currentPlayer = 1
  var gameFinished = false

  while(gameFinished == false) {
    Console.println("")
    Console.println("Ready player " + currentPlayer.toString + "!")
    Console.println("What row do you want to put your marker in (1-" + n.toString + ")?")
    var selectedRow = Console.readInt()-1

    Console.println("What column do you want to put your marker in (1-" + n.toString + ")?")
    var selectedCol = Console.readInt()-1

    if(board(selectedRow)(selectedCol) == 0) {
      board(selectedRow)(selectedCol) = currentPlayer

      if(isWinningMove(currentPlayer, selectedRow, selectedCol)) {
        Console.println("Player " + currentPlayer.toString + " won!")
        gameFinished = true
      }

      currentPlayer = if(currentPlayer == 1) 2 else 1
    } else{
      Console.println("That cell is already taken. Choose another!")
    }

    printBoard
  }

  def printBoard {
    Console.println("")
    Console.println(" *** Board status *** ")
    board.foreach(row => Console.println(row.foldLeft("")((result, item) => result + item.toString())))
  }

  def isWinningMove(player: Int, row: Int, col: Int):Boolean = {
    if(board(row).exists(x => x != player) == false) { return true }
    var vertical = board.map(x => x(col))
    if(vertical.exists(x => x != player) == false) { return true }

    if(checkForwardDiag() == true) return true
    if(checkBackwardDiag() == true) return true

    return false
  }

  def checkForwardDiag():Boolean = {
    for(i <- 0 until n) {
      if(board(i)(i) != currentPlayer) return false
    }
    return true
  }

  def checkBackwardDiag():Boolean = {
    for(i <- 0 until n) {
      if(board(i)(n-i-1) != currentPlayer) return false
    }
    return true
  }
}

var foo = new Board()
