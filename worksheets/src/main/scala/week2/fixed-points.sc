package week2

import math.abs

val tolerance = 0.0001
// Stabilizing by average
def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
def isCloseEnough(x: Double, y: Double) =
  abs((x - y) / x) / x < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
    println("guess = " + guess)
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

fixedPoint(x => 1 + x/2)(1)

// We will average over the successive values
def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)
sqrt(2)

def sqrt2(x: Double) =
  fixedPoint(averageDamp(y => x / y))(1)
sqrt(2)