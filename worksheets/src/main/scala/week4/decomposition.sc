package week4

trait Expr {
  // Classification methods
  def isNumber: Boolean
  def isSum: Boolean
  // Accessor methods
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Number(n: Int) extends Expr {
  override def isNumber: Boolean = true
  override def isSum: Boolean = false
  override def numValue: Int = n
  override def leftOp: Expr =
    throw new Error("Number.leftOp")
  override def rightOp: Expr =
    throw new Error("Number.rightOp")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  override def isNumber: Boolean = false
  override def isSum: Boolean = true
  override def numValue: Int =
    throw new Error("Sum.numValue")
  override def leftOp: Expr = e1
  override def rightOp: Expr = e2
}

object test {
  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }

  print(eval(new Sum(new Number(1), new Number(2))))
}