package main.scala.pacman.model

import Array._
import main.scala.pacman.helper.MazeHelper

case class Maze (food: Food) {
  
  private var map = ofDim[Int](30,30);
  
  def init {
    map = MazeHelper.draw
  }
  
  def isADot(position: Position) = map(position.line)(position.column) equals '·'
  
  def isAConner(position: Position) = map(position.line)(position.column) equals '█'
  
  def isAFood(position: Position) = this.food.position equals position
}