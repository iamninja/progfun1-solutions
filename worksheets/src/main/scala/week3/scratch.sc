def error(msg: String) = throw new Error(msg)
//error("test")

val x = null
val y: String = x

// Cant do this
//val z: Int = Null

if (true) 1 else false