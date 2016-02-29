package com.splyer.marsrover

import org.scalatest.FlatSpec


class MarsRoverSpec extends FlatSpec {

  "Plateau" should "have size" in {
    val plateau = Plateau(10, 15)
    assert(plateau.size.x == 10)
    assert(plateau.size.y == 15)
  }

  "Mars rover" should "hold initial position ad direction" in {
    val rover = MarsRover(1, 1, 'N', Plateau(10, 15))
    assert(rover.location == Coordinate(1,1))
  }

  it should "mover forward" in {
    val rover = MarsRover(1, 1, 'N', Plateau(10, 15))
    rover.processCommands("M")
    assert(rover.location == Coordinate(1, 2))
  }
}
