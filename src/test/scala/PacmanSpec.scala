package test.scala

import org.specs2.mutable.Specification
import main.scala.pacman.model.Maze
import main.scala.pacman.model.Food
import main.scala.pacman.model.Pacman
import main.scala.pacman.model.Position
import scala.collection.mutable.Stack
import main.scala.pacman.parse.Parser

class PacmanSpec extends Specification {

  "Pacman" >> {
    "must find a food at maze 1" >> {
      val file = "/home/orlando/workspace/pacman/src/main/resources/maze-1"
      val result = Parser.process(file)
      val maze = result._1
      val pacman = result._2
      val pathToFoodExpected = Stack(new Position(5, 5), new Position(5, 4), new Position(5, 3), new Position(5, 2), new Position(5, 1))
      pacman.findPathToFood(maze)
      pacman.pathToFood.equals(pathToFoodExpected) must beTrue
    }

    "must find a food at maze 2" >> {
      val file = "/home/orlando/workspace/pacman/src/main/resources/maze-2"
      val result = Parser.process(file)
      val maze = result._1
      val pacman = result._2
      val pathToFoodExpected = Stack(new Position(5, 1), new Position(5, 2), new Position(5, 3), new Position(5, 4), new Position(5, 5), new Position(5, 6), new Position(5, 7), new Position(5, 8), new Position(5, 9), new Position(5, 10), new Position(5, 11), new Position(5, 12), new Position(5, 13), new Position(5, 14), new Position(5, 15), new Position(5, 16), new Position(5, 17), new Position(5, 18), new Position(4, 18), new Position(3, 18), new Position(2, 18), new Position(1, 18), new Position(1, 17), new Position(1, 16), new Position(2, 16), new Position(3, 16), new Position(3, 15), new Position(3, 14), new Position(3, 13), new Position(3, 12), new Position(3, 11), new Position(3, 10), new Position(3, 9))
      pacman.findPathToFood(maze)
      pacman.pathToFood.equals(pathToFoodExpected) must beTrue
    }
  }
}