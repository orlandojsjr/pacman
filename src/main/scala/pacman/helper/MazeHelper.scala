package main.scala.pacman.helper

import scala.io.Source
import Array._
import main.scala.pacman.model.Maze
import scala.collection.mutable.Stack
import main.scala.pacman.model.Position
import main.scala.pacman.model.Pacman

object MazeHelper {

  private val file = "/home/orlando/workspace/pacman/src/main/resources/maze"

  def draw = {
    val map = ofDim[Char](7, 20)
    val lines = Source.fromFile(file).getLines
    var x, y = 0
    lines.foreach {
      line =>
        {
          y = 0
          line.foreach {
            str =>
              map(x)(y) = str
              y += 1
          }
          x += 1
        }
    }
    map
  }

  def show(maze: Maze, pacman: Pacman) {
    blankLine
    putPathToFood(maze, pacman)
    putPacman(maze, pacman)
    putFood(maze, pacman)
    showMaze(maze)
  }

  private def blankLine() { println("") }

  private def putPathToFood(maze: Maze, pacman: Pacman) {
    if (!pacman.pathToFood.isEmpty) {
      pacman.pathToFood.foreach { x => maze.map(x.line)(x.column) = '*' }
    }
  }

  private def putPacman(maze: Maze, pacman: Pacman) {
    maze.map(pacman.initialPosition.line)(pacman.initialPosition.column) = '☺'
  }

  private def putFood(maze: Maze, pacman: Pacman) {
    maze.map(maze.food.position.line)(maze.food.position.column) = 'ϖ'
  }

  private def showMaze(maze: Maze) {
    println(maze.map.map(_.mkString).mkString("\n"))
  }
}