import scala.io.StdIn.readLine
import scala.util.Random



object Main extends App {
  println("Welcome to Arnav's Scala CLI Lottery!")

  var lotteryArray = new Array[Int](7)
  var userArray = new Array[Int](7)
  var selectValue: Int = 0
  var score: Int = 0;

  var gameLoop: Boolean = true;
  while(gameLoop) {
    
    for(i <- 0 to 6) {
      lotteryArray(i) = Random.between(0, 100) 
    }

    println("Fill your lottery ticket with values between 0 and 100!") 

    for(i <- 0 to 6) {
      print(s"Enter value number ${i + 1} out of 7: ")
      try {
        selectValue = readLine().toInt
      } catch {
        case e: NumberFormatException => numberFormatExceptionCaught(i)
      }
      
      if(selectValue >= 0 && selectValue <= 100) {
        userArray(i) = selectValue
      } 
      selectValue = 0;
    }

    score = giveLotteryScore(lotteryArray, userArray)

    //CONTINUE FROM HERE 
    println(s"Your score is: $score. The correct values are: ")
    for(i <- 0 to 6) {
      print(s" $lotteryArray(i),")
    } 
    println(" ")
 

    
    gameLoop = false;
  }

  def numberFormatExceptionCaught(index: Int): Unit = {
    println(s"Invalid input on lottery ticket slot: ${index + 1}")
    println("This slot will be defaulted to zero.")
    userArray(index) = 0
  }

  

  def giveLotteryScore(userTicket: Array[Int], cpuTicket: Array[Int]): Int = {
    var score: Int = 0;
    
    for(i <- 0 to 6) {
      if(userTicket(i) == cpuTicket(i)) {
        score+=14;
      }
    }

    if(score >= 50) {
      score+=2
    }
    return score;
  }

  
  
}
