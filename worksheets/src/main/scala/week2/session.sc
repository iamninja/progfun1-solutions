def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}

//sum (x => x*x, 3, 5) // =50

def sum2(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

//def sumCubes = sum2(x => x * x * x)
//sumCubes(1, 10)

//val sumSquares = sum2(x=> x * x)(3,5)

// Equivalent to sumF but shorter
def sum3(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum3(f)(a+1, b)

def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 else f(a) * product(f)(a+1, b)

product(x => x * x)(3, 4)

def fact(n: Int) = product(x => x)(1, n)
fact(4)

def fun(f: Int => Int)(id: Int, operator: (Int, Int) => Int)(a: Int, b: Int): Int =
  if (a > b) id else operator(f(a), fun(f)(id, operator)(a + 1, b))
fun(x => x * x)(1, (x, y) => x * y)(3, 4)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

def product2(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)

product2(x => x*x)(3, 4)