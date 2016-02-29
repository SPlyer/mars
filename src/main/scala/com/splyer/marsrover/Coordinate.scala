package com.splyer.marsrover


case class Coordinate(x: Int, y: Int) {

  def move(coordinate: Coordinate): Coordinate = {
    Coordinate(x = x + coordinate.x, y = y + coordinate.y)
  }

}
