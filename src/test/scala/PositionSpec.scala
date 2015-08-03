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
  
  "Position" >> {
    "must gimme right position" >> {
      val position = new Position(1,1)
      val expected = new Position(1,2)
      expected equals position.right must beTrue
    }
    
    "must gimme left position" >> {
      val position = new Position(2,2)
      val expected = new Position(2,1)
      expected equals position.left must beTrue
    }
    
    "must gimme up position" >> {
      val position = new Position(2,2)
      val expected = new Position(1,2)
      expected equals position.up must beTrue
    }
    
    "must gimme down position" >> {
      val position = new Position(2,2)
      val expected = new Position(3,2)
      expected equals position.down must beTrue
    }
  }
}