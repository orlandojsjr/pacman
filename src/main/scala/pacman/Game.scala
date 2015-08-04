package main.scala.pacman

import main.scala.pacman.helper.MazeHelper
import main.scala.pacman.model.Maze
import main.scala.pacman.model.Food
import main.scala.pacman.model.Position
import main.scala.pacman.model.Pacman

object Game {
  
  def main(args: Array[String]) { 
    val food = new Food(new Position(1,1))
    val maze = new Maze(food)
    val pacman = new Pacman(new Position(5,18))

    MazeHelper.show(maze, pacman)
    pacman.findPathToFood(maze)
    MazeHelper.show(maze, pacman)
  }
}