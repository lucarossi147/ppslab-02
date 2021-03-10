package u02

object Shapes extends App{

  sealed trait Shape
  case class Rectangle(base: Double, height: Double) extends Shape
  case class Circle(radius: Double) extends Shape
  case class Square(side: Double) extends Shape

  def perimeter(shape:Shape): Double = shape match {
    case Square(s) => s * 4
    case Rectangle(b,h) => (b * 2) + (h * 2)
    case Circle(r) => 2 * math.Pi * r
    case  _ => -1
  }

  def area(shape:Shape): Double = shape match {
    case Square(s) => s * s
    case Rectangle(b,h) => b * h
    case Circle(r) => r * r * math.Pi
    case  _ => -1
  }
}
