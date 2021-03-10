package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._
import u02.Shapes.{Circle, Rectangle, Square, area, perimeter}

class ShapesTest {
  val length = 2:Double

  val square = Square(length)
  val rectangle = Rectangle(length,length + length)
  val circle = Circle(length)

  @Test def testPerimeter(): Unit ={
    assertEquals(length*4, perimeter(square))
    assertEquals((length*2)+(length+length)*2,perimeter(rectangle))
    assertEquals(length*math.Pi*2, perimeter(circle))
  }

  @Test def testArea(): Unit ={
    assertEquals(length*length, area(square))
    assertEquals(length*(length+length),area(rectangle))
    assertEquals(length*length*math.Pi, area(circle))
  }

}
