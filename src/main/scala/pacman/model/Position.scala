package main.scala.pacman.model

case class Position (line: Int = 0, column : Int = 0) extends Equals {
  
  def right = new Position(this.line, this.column + 1)
  
  def left = new Position(this.line, this.column - 1)
  
  def up = new Position(this.line - 1, this.column)
  
  def down = new Position(this.line + 1, this.column)
  
  def canEqual(other: Any) = other.isInstanceOf[main.scala.pacman.model.Position]

  override def equals(other: Any) = {
    other match {
      case that: main.scala.pacman.model.Position => { 
        that.canEqual(Position.this) match {
          case true => that.line == this.line && that.column == this.column
          case _ => false
        }
      } 
      case _ => false
    }
  }
}