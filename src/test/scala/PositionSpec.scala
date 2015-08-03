package test.scala

import org.specs2.mutable.Specification
import main.scala.pacman.model.Position

class PositionSpec extends Specification {
  
  "Position equals method" >> {
    "must be equals to another position" >> {
      val positionOne = new Position(1,1)
      val positionTwo = new Position(1,1)
      positionOne equals positionTwo must beTrue
    }
    
    "must be not equals to another position" >> {
      val positionOne = new Position(1,1)
      val positionTwo = new Position(1,2)
      positionOne equals positionTwo must beFalse
    }
  }
}