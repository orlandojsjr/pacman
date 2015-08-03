package main.scala.pacman.model

import Array._
import main.scala.pacman.helper.MazeHelper

case class Maze (food: Food) {
  
  private var _map = MazeHelper.draw
  
  def map = _map
  
  private def isADot(position: Position) = _map(position.line)(position.column) equals '·'
  
  private def isAConner(position: Position) = _map(position.line)(position.column) equals '█'
  
  def isAValidPosition(position: Position) = isADot(position) || isAFood(position)
  
  def isAFood(position: Position) = this.food.position equals position
}