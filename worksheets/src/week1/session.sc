import scala.annotation.tailrec

//1 + 2
def abs(x: Double) = if (x > 0) x else -x
//abs(-5)
//abs(5)

def sqrt(x: Double) = {
  @tailrec
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) / x < 0.001

  def improve(guess: Double) = (guess + x / guess) / 2

  sqrtIter(1.0)
}

sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e60)

@tailrec
def factorial(n: Int, res: Int = 1): Int =
  if (n == 1) res else factorial(n-1, res*n)

def factorial2(n: Int): Int = {
  def loop(acc: Int, n: Int): Int = if (n == 0) acc else loop(acc * n, n-1)
  loop(1, n)
}
factorial(4)
factorial2(4)