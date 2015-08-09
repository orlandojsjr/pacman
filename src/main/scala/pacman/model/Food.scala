package main.scala.pacman.model

case class Food (position: Position) extends GameComponent {

  override def displayableValue = s"C=(${position.line}x${position.column})"
}