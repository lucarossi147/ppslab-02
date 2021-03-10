package u02

object HelloScala extends App {

  val parity1: Int => String = {
    case x if x % 2 == 0  => "even"
    case _ => "odd"
  }
  def parity2( x:Int ):String = x match {
      case x if x % 2 == 0  => "even"
      case _ => "odd"
  }

  println(parity1(5));
  println(parity1(2));

  println(parity2(5));
  println(parity2(2));

  val empty: String =>Boolean = _ == ""
  def empty1(s:String):Boolean = s == ""

//  println(empty("ciccia"))
//  println(empty(""))

  val neg: (String =>Boolean) => (String => Boolean) = p => !p(_)

  def neg1[A](p:A => Boolean): A=>Boolean = !p(_)


  val notEmpty: String => Boolean = neg(empty);

  println(notEmpty("foo"))// true
  println(notEmpty("")) //false




//currying

  val min: (Int,Int) => Boolean = (x, y) => x <= y

  val p1: Int => Int => Int => Boolean = x => y => z => min(x, y) && min(y, z)
  val p2: (Int, Int, Int) => Boolean = (x,y,z) => min(x, y) && min(y, z)
  def p3(x: Int)(y: Int)(z: Int): Boolean = min(x, y) && min(y, z)
  def p4(x:Int, y: Int, z: Int): Boolean =  min(x, y) && min(y, z)

  println(p1(1)(2))
  println(p1(3))
  println(p2(4,5,6))
  println(p4(4,5,6))
  println(p2(5,5,6))
  println(p4(6,5,6))




  
  //composition
  def compose(f: Int=>Int, g: Int=>Int):Int => Int  = { x => f(g(x)) }

  def genericCompose[A, B, C](f: B => C,g: A => B):A => C ={ x => f(g(x)) }
  println(compose(_-1,_*2)(5))

  //ho problemi con la generic qui sotto
  //println(genericCompose(_-1,_*2)(5))



  //fibonacci
  def fib(n:Int):Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fib(n-1) + fib(n - 2)
}

  def fib2(n: Int): Int = {
    @annotation.tailrec
    def _fib(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case 1 => b
      case _ => _fib( n - 1, b, a+b)
    }
    _fib(n, 0, 1)
  }

  println(fib(0),fib(1),fib(2),fib(3),fib(4))
  println(fib2(0),fib2(1),fib2(2),fib2(3),fib2(4))
}
