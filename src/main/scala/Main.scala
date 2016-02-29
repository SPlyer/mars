
import com.splyer.marsrover.InputProcessor


object Main {

  def main(args: Array[String]): Unit = {
    InputProcessor.process(args(0)).foreach(rover =>
      println(s"${rover.location.x} ${rover.location.y} ${rover.heading.toString.head}")
    )
  }

}
