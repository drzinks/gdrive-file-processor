val age = 42

//pattern matching
age match {
  case 42 => println("chlopie, masz 42 lata na karku")
  case _ => println("nie wiem ile masz lat")
}

//inject variable value
println(f"$age%05d is not that old yet")

println(s"${age+3}")

