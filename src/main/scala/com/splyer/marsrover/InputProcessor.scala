package com.splyer.marsrover

import scala.io.Source


object InputProcessor {

  private def getSize(data: String) = {
    val bits = data.split(" ")
    new Size(bits(0).toInt, bits(1).toInt)
  }

  private def createRover(data: String, plateau: Plateau) = {
    val bits = data.split(" ")
    Rover(bits(0).toInt, bits(1).toInt, bits(2).head, plateau)
  }

  def process(fileName: String) = {
    val lines = Source.fromFile(fileName).getLines()
    val plateau = new Plateau(getSize(lines.next()))

    for (List(position, command) <- lines.sliding(2, 2))
      yield Rover.processCommands(createRover(position, plateau), command)
}

}
