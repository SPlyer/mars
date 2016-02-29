package com.splyer.marsrover


class Rover(val location: Coordinate, val heading: Heading, val plateau: Plateau) {

  def move(): Rover = {

    val newLocation = location.move(
      heading match {
        case North => Coordinate(0, 1)
        case South => Coordinate(0, -1)
        case West => Coordinate(-1, 0)
        case East => Coordinate(1, 0)
      }
    )
    new Rover(newLocation, heading, plateau)

  }


  def turnRight(): Rover = {
    val newHeading = heading match {
      case North => East
      case South => West
      case West => North
      case East => South
    }
    new Rover(location, newHeading, plateau)
  }

  def turnLeft(): Rover = {
    val newHeading = heading match {
      case North => West
      case South => East
      case West => South
      case East => North
    }
    new Rover(location, newHeading, plateau)

  }

  def processCommands(command: String) = {
    command.foreach { cmd: Char =>
      cmd match {
        case 'M' => move()
        case 'L' => turnLeft()
        case 'R' => turnRight()
      }

    }
  }
}


object Rover {

  def apply(x: Int, y: Int, headingChar: Char, plateau: Plateau) = {
    val heading = headingChar match {
      case 'N' => North
      case 'S' => South
      case 'W' => West
      case 'E' => East
    }
    new Rover(Coordinate(x, y), heading, plateau)
  }

  def processCommands(rover: Rover, commands: String): Rover = {
      val newRover = commands.head match {
        case 'M' => rover.move()
        case 'L' => rover.turnLeft()
        case 'R' => rover.turnRight()
      }
      if (commands.tail.isEmpty)
        newRover
      else
        processCommands(newRover, commands.tail)
  }

}