package com.natpryce.diamond.examples

object DiamondApp extends App {
  import Diamond.diamond

  println(diamond(DiamondChar.from(args.lift(0).getOrElse("Z").charAt(0)).get))
}
