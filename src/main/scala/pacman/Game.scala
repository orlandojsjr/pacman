package main.scala.pacman

import main.scala.pacman.helper.MazeHelper
import main.scala.pacman.model.Maze
import main.scala.pacman.model.Food
import main.scala.pacman.model.Position
import main.scala.pacman.model.Pacman
import main.scala.pacman.parse.Parser

object Game {
  
  def main(args: Array[String]) {
    val result = Parser.process()
    val maze = getMaze(result)
    val pacman = getPacman(result)

    MazeHelper.show(maze, pacman)
    pacman.findPathToFood(maze)
    MazeHelper.show(maze, pacman)
  }

  private def getMaze(tuple: (Maze, Pacman)) = tuple._1

  private def getPacman(tuple: (Maze, Pacman)) = tuple._2
}