package com.splyer.marsrover


class Plateau(val size: Size)


object Plateau {

  def apply(x: Int, y: Int) = {
    new Plateau(Size(x, y))
  }

}
