package test.scala

import org.specs2.mutable.Specification
import main.scala.pacman.model.Maze
import main.scala.pacman.model.Food
import main.scala.pacman.model.Pacman
import main.scala.pacman.model.Position
import scala.collection.mutable.Stack

class PacmanSpec extends Specification {

  "Pacman" >> {
    "must find a food" >> {
      val food = new Food(new Position(5, 5))
      val maze = new Maze(food)
      val pacman = new Pacman(new Position(5, 1))
      val pathToFoodExpected = Stack(new Position(5, 5), new Position(5, 4), new Position(5, 3), new Position(5, 2), new Position(5, 1))
      pacman.findPathToFood(maze)
      pacman.pathToFood.equals(pathToFoodExpected) must beTrue
    }
  }
}