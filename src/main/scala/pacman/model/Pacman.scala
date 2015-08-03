package main.scala.pacman.model

import Array._
import scala.collection.mutable.Stack
import scala.collection.mutable.Set

case class Pacman(initialPosition: Position) {

  private val positionsIhaveBeen = Set[String]()
  private var positionsStack = Stack[Position](initialPosition)

  def findPathFood(maze: Maze) = {
    while (!maze.isAFood(positionsStack.top)) {
      this.goToNextStep(maze)
    }
    positionsStack
  }
  
  def pathToFood = positionsStack

  private def goToNextStep(maze: Maze) {
    val nextPosition = defineNextPositionStep(maze)
    nextPosition.isDefined match {
      case true  => positionsStack.push(nextPosition.get)
      case false => if (positionsStack.size > 0) positionsStack.pop()
    }
  }

  private def defineNextPositionStep(maze: Maze) = {
    val actualPosition = positionsStack.top
    var nextPosition = tryGetNextPositionStep(actualPosition.right, maze)

    if (!nextPosition.isDefined) nextPosition = tryGetNextPositionStep(actualPosition.up, maze)
    if (!nextPosition.isDefined) nextPosition = tryGetNextPositionStep(actualPosition.left, maze)
    if (!nextPosition.isDefined) nextPosition = tryGetNextPositionStep(actualPosition.down, maze)

    nextPosition
  }

  private def tryGetNextPositionStep(candidateNextPosition: Position, maze: Maze): Option[Position] = {
    !iHaveBeenHere(candidateNextPosition) && maze.isAValidPosition(candidateNextPosition) match {
      case true => {
        pushPositionIHaveBeen(candidateNextPosition)
        Option(candidateNextPosition)
      }
      case _ => None
    }
  }

  private def pushPositionIHaveBeen(position: Position) {
    positionsIhaveBeen.add(position.toString)
  }

  private def iHaveBeenHere(position: Position) = positionsIhaveBeen(position.toString)
}