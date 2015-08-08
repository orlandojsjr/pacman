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
    val result = Parser.process(file(gimmeFileId(args)))
    val maze = gimmeMaze(result)
    val pacman = gimmePacman(result)

    MazeHelper.show(maze, pacman)
    pacman.findPathToFood(maze)
    MazeHelper.show(maze, pacman)
  }

  private def gimmeMaze(tuple: (Maze, Pacman)) = tuple._1

  private def gimmePacman(tuple: (Maze, Pacman)) = tuple._2

  private def gimmeFileId(fileId: Array[String]) = fileId(0)

  private def file(fileId: String) = s"${_file}-${fileId}"
}