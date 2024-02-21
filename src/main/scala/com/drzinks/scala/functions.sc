def cubeIt(a : Int) : Int = {
  a * a * a
}

def transform(a: Int, f: Int=>Int): Int = {
  f(a)
}

println(transform(5, cubeIt))

val result = transform(2, e => e*2*3*4)

println(result)