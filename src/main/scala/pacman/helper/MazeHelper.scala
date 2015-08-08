package main.scala.pacman.helper

import scala.io.Source
import Array._
import main.scala.pacman.model.Maze
import scala.collection.mutable.Stack
import main.scala.pacman.model.Position
import main.scala.pacman.model.Pacman

object MazeHelper {

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