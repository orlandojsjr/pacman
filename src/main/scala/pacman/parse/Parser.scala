package main.scala.pacman.parse

import scala.Array.ofDim
import scala.io.Source
import main.scala.pacman.model.Position
import main.scala.pacman.model.Food
import main.scala.pacman.model.Pacman
import main.scala.pacman.model.Maze

object Parser {

  private val _file = "/home/orlando/workspace/pacman/src/main/resources/maze-2"
  private val pacmanPattern = """P=\([1-9][0-9]?\,[1-9][0-9]?\)""".r
  private val foodPattern = """C=\([1-9][0-9]?\,[1-9][0-9]?\)""".r
  private val gridSizePattern = """[1-9][0-9]?x[1-9][0-9]?""".r
  private val numberPattern = """[1-9][0-9]?""".r

  def process() : (Maze, Pacman) = {

    var maze: Maze = null
    var pacman: Pacman = null
    var gridSize: Position = null
    var array = ofDim[Char](0, 0)
    var x, y = 0

    val lines = Source.fromFile(file).getLines
    lines.foreach {
      line =>
        {
          line match {
            case pacmanPattern(_*)   => pacman = new Pacman(gimmePosition(line))
            case foodPattern(_*)     => maze = new Maze(new Food(gimmePosition(line)))
            case gridSizePattern(_*) => array = ofDim[Char](gimmePosition(line).line, gimmePosition(line).column)
            case _ => {
              y = 0
              line.foreach {
                str =>
                  array(x)(y) = str
                  y += 1
              }
              x += 1
            }
          }
        }
    }
    maze.map(array)
    (maze, pacman)
  }

  private def gimmePosition(source: String) = {
    val result = numberPattern.findAllIn(source).toList
    new Position(result(0).toInt, result(1).toInt)
  }

  private def file = _file //+ scala.util.Random.nextInt(2)
}