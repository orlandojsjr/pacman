package test.scala

import org.specs2.mutable.Specification
import main.scala.pacman.model.Maze
import main.scala.pacman.model.Pacman
import main.scala.pacman.parse.Parser
import org.specs2.mutable.Before
import main.scala.pacman.model.Position
import org.specs2.specification.BeforeAll

class ParseSpec extends Specification with BeforeAll {

  var pacman: Pacman = _
  var maze: Maze = _

  override def beforeAll {
    val file = "/home/orlando/workspace/pacman/src/main/resources/maze-1"
    val result = Parser.process(file)
    maze = result._1
    pacman = result._2
  }

  "ParseSpec result" >> {
    "must find pacman position" >> {
      val file = "/home/orlando/workspace/pacman/src/main/resources/maze-1"
      val result = Parser.process(file)
      val expectedPosition = new Position(5,1)
      expectedPosition equals pacman.initialPosition
    }

    "must find food position" >> {
      val file = "/home/orlando/workspace/pacman/src/main/resources/maze-1"
      val result = Parser.process(file)
      val expectedPosition = new Position(5,5)
      expectedPosition equals maze.food.position
    }

    "must find maze size" >> {
      val file = "/home/orlando/workspace/pacman/src/main/resources/maze-1"
      val result = Parser.process(file)
      val expectedLines = 7
      val expextedColumns = 20
      expectedLines equals maze.map.length
      expextedColumns equals maze.map(0).length
    }
  }
}