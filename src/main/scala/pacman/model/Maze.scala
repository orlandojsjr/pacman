package main.scala.pacman.model

import Array._
import main.scala.pacman.helper.MazeHelper

case class Maze (var food: Food) extends GameComponent {
  
  var _map: Array[Array[Char]] = _
  
  def map = _map

  def map(m: Array[Array[Char]]){ _map = m }
  
  private def isADot(position: Position) = _map(position.line)(position.column) equals '·'
  
  private def isAConner(position: Position) = _map(position.line)(position.column) equals '█'
  
  def canIStayHere(position: Position) = isADot(position) || isAFood(position)
  
  def isAFood(position: Position) = this.food.position equals position

  override def displayableValue = s"${_map.length}x${_map(0).length}"
}