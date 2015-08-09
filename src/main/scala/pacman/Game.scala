package main.scala.pacman

import main.scala.pacman.helper.MazeHelper
import main.scala.pacman.model.Maze
import main.scala.pacman.model.Food
import main.scala.pacman.model.Position
import main.scala.pacman.model.Pacman
import main.scala.pacman.parse.Parser

object Game {
  
  private val _file = "/home/orlando/workspace/pacman/src/main/resources/maze"

  def main(args: Array[String]) {
    val gameComponents = Parser.process(file(fileId(args)))
    val maze = gameComponents._1
    val pacman = gameComponents._2

    MazeHelper.show(maze, pacman)
    pacman.findPathToFood(maze)
    MazeHelper.show(maze, pacman)
  }

  private def fileId(args: Array[String]) = args(0)

  private def file(fileId: String) = s"${_file}-${fileId}"
}