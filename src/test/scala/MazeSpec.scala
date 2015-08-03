package test.scala


import main.scala.pacman.model.Maze
import main.scala.pacman.model.Food
import main.scala.pacman.model.Position
import org.specs2.mutable.Specification

class MazeSpec extends Specification {
  
  val maze = new Maze(new Food(new Position(1,1))); 
  
  "Maze" >> {
    "valid dot position" >> {
      val dot = new Position(2,1)
      maze.isAValidPosition(dot) must beTrue
    }
    
    "invalid dot position" >> {
      val dot = new Position(0,0)
      maze.isAValidPosition(dot) must beFalse
    }
    
    "valid food position" >> {
      val food = new Position(1,1)
      maze.isAFood(food) must beTrue
    }
    
    "invalid food position" >> {
      val dot = new Position(2,1)
      maze.isAFood(dot) must beFalse
    }
  }
}