object Testobject {
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Var(name: String) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Sum(l, r) => show(l) + " + " + show(r)
    case Var(name) => name
    case Prod(l: Sum, r: Sum) => "(" + show(l) + ")" + " * " + "(" + show(r) + ")"
    case Prod(l: Sum, r) => "(" + show(l) + ")" + " * " + show(r)
    case Prod(l, r: Sum) => show(l) + " * " + "(" + show(r) + ")"
    case Prod(l, r) => show(l) + " * " + show(r)
  }

  show(Number(2))
  show(Sum(Number(2), Number(3)))
  show(Sum(Prod(Number(2), Var("x")), Var("y")))
  show(Prod(Sum(Number(2), Var("x")), Var("y")))
  show(Prod(Number(2), Sum(Var("x"), Var("y"))))
  show(Prod(Number(2), Number(3)))
}