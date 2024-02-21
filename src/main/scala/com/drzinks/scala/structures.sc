import java.util

val passangers = ("Jaroslaw", "Michal", "Maciej")

println(passangers._1)

val industriesMap = ("Sii" -> "good", "Billennium" -> "so-so")

println(industriesMap._2._2)

val names = List("maciej buczek", "michal golebiowski", "jaroslaw pigula")

val namesCapitalized = names.map(
  e => e.reverse)
println(namesCapitalized)

