package com.splyer.marsrover

import org.scalatest.FlatSpec


class MarsRoverSpec extends FlatSpec {

  "Plateau" should "have size" in {
    val plateau = Plateau(10, 15)
    assert(plateau.size.x == 10)
    assert(plateau.size.y == 15)
  }

  "Mars rover" should "hold initial position and direction" in {
    val rover = Rover(1, 1, 'N', Plateau(10, 15))
    assert(rover.location == Coordinate(1,1))
  }

  it should "move forward" in {
    val rover = Rover.processCommands(Rover(1, 1, 'N', Plateau(10, 15)), "M")
    assert(rover.location == Coordinate(1, 2))
  }

  it should "turn left" in {
    val rover = Rover.processCommands(Rover(1, 1, 'N', Plateau(10, 15)), "L")
    assert(rover.heading == West)
  }

  it should "turn right" in {
    val rover = Rover.processCommands(Rover(1, 1, 'N', Plateau(10, 15)),"R")
    assert(rover.heading == East)
  }

  it should "process set of left turns and moves" in {
    val rover = Rover.processCommands(Rover(1, 2, 'N', Plateau(5, 5)), "LMLMLMLMM")
    assert(rover.heading == North)

    assert(rover.location == Coordinate(1,3))
  }

  it should "process set of right turns and moves" in {
    val rover = Rover.processCommands(Rover(3, 3, 'E', Plateau(5, 5)), "MMRMMRMRRM")
    assert(rover.heading == East)
    assert(rover.location == Coordinate(5,1))
  }

  it should "process set of left / right turns and moves" in {
    val rover = Rover.processCommands(Rover(0, 0, 'N', Plateau(5, 5)), "MMRMMLM")
    assert(rover.heading == North)
    assert(rover.location == Coordinate(2,3))
  }
}
