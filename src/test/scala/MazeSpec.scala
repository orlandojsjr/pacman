package test.scala


import main.scala.pacman.model.Maze
import main.scala.pacman.model.Food
import main.scala.pacman.model.Position
import org.specs2.mutable.Specification
import org.specs2.specification.Before
import main.scala.pacman.parse.Parser
import org.specs2.specification.BeforeEach
import org.specs2.specification.BeforeAll

class MazeSpec extends Specification with BeforeAll {
  
  var maze: Maze = _

  override def beforeAll {
    val file = "/home/orlando/workspace/pacman/src/main/resources/maze-1"
    maze = Parser.process(file)._1
  }
  
  "Maze" >> {
    "valid dot position" >> {
      val dot = new Position(2,1)
      maze.canIMoveHere(dot) must beTrue
    }
    
    "invalid dot position" >> {
      val dot = new Position(0,0)
      maze.canIMoveHere(dot) must beFalse
    }
    
    "valid food position" >> {
      val food = new Position(5,5)
      maze.isAFood(food) must beTrue
    }
    
    "invalid food position" >> {
      val dot = new Position(2,1)
      maze.isAFood(dot) must beFalse
    }
  }
}