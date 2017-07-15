package week4
import week3.{Cons, List, Nil}

object List {
  // List(1,2) = List.apply(1,2)
  def apply[T](x1: T, x2: T): List[T] =
    new Cons(x1, new Cons(x2, new Nil))
  def apply[T](x1: T): List[T] =
    new Cons(x1, new Nil)
  def apply[T]() = new Nil
}