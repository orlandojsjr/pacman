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

  def screen(maze: Maze, pacman: Pacman) {
    println("")
    if (!pacman.pathToFood.isEmpty) {
      pacman.pathToFood.foreach { x => maze.map(x.line)(x.column) = '*' }
    }
    maze.map(pacman.initialPosition.line)(pacman.initialPosition.column) = '☺'
    maze.map(maze.food.position.line)(maze.food.position.column) = 'ϖ'
    println(maze.map.map(_.mkString).mkString("\n"))
  }
}