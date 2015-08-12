package main.scala.pacman.model

import Array._
import scala.collection.mutable.Stack
import scala.collection.mutable.Set

case class Pacman(initialPosition: Position) extends GameComponent {

  private val positionsIhaveBeen = Set[String]()
  private var _pathToFood = Stack[Position](initialPosition)

  def findPathToFood(maze: Maze) = {
    while (!maze.isAFood(currentPosition)) {
      this.goToNextPosition(maze)
    }
    _pathToFood
  }

  def pathToFood = _pathToFood

  override def displayableValue = s"P=(${initialPosition.line}x${initialPosition.column})"

  private def goToNextPosition(maze: Maze) {
    val nextPosition = findNextPosition(maze)
    nextPosition.isDefined match {
      case true  => _pathToFood.push(nextPosition.get)
      case false => if (_pathToFood.size > 0) _pathToFood.pop()
    }
  }

  private def findNextPosition(maze: Maze) = {
    var nextPosition = tryGetNextPosition(currentPosition.right, maze)
    if (!nextPosition.isDefined) nextPosition = tryGetNextPosition(currentPosition.up, maze)
    if (!nextPosition.isDefined) nextPosition = tryGetNextPosition(currentPosition.left, maze)
    if (!nextPosition.isDefined) nextPosition = tryGetNextPosition(currentPosition.down, maze)
    nextPosition
  }

  private def tryGetNextPosition(nextPositionCandidate: Position, maze: Maze): Option[Position] = {
    !iHaveBeenHere(nextPositionCandidate) && maze.canIMoveHere(nextPositionCandidate) match {
      case true => {
        pushPositionIHaveBeen(nextPositionCandidate)
        Option(nextPositionCandidate)
      }
      case _ => None
    }
  }

  private def pushPositionIHaveBeen(position: Position) {
    positionsIhaveBeen.add(position.toString)
  }

  private def iHaveBeenHere(position: Position) = positionsIhaveBeen(position.toString)

  private def currentPosition = _pathToFood.top
}