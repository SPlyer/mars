package com.splyer.marsrover


sealed trait Heading
case object North extends Heading
case object South extends Heading
case object West extends Heading
case object East extends Heading


