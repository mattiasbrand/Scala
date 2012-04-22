class Board {
  val n = 3
  var board = Array.ofDim[Int](n, n)
  var currentPlayer = 1
  var gameFinished = false

  while(gameFinished == false) {
    Console.println("Ready player " + currentPlayer.toString + "!")
    Console.println("What row do you want to put your marker in (1-" + n.toString + ")?")
    var selectedRow = Console.readInt()-1

    Console.println("What column do you want to put your marker in (1-" + n.toString + ")?")
    var selectedCol = Console.readInt()-1

    board(selectedRow)(selectedCol) = currentPlayer

    printBoard
    if(isWinningMove(currentPlayer, selectedRow, selectedCol)) {
      Console.println("Player " + currentPlayer.toString + " won!")
      gameFinished = true
    }

    currentPlayer = if(currentPlayer == 1) 2 else 1
  }

  def printBoard {
    Console.println("")
    Console.println(" *** Board status *** ")
    Console.println(board(0)(0).toString() + board(0)(1).toString() + board(0)(2).toString())
    Console.println(board(1)(0).toString() + board(1)(1).toString() + board(1)(2).toString())
    Console.println(board(2)(0).toString() + board(2)(1).toString() + board(2)(2).toString())
  }

  def isWinningMove(player: Int, row: Int, col: Int):Boolean = {
    if(board(row).exists(x => x != player) == false) { return true }
    var vertical = board.map(x => x(col))
    if(vertical.exists(x => x != player) == false) { return true }

    return false
  }
}

var foo = new Board()
