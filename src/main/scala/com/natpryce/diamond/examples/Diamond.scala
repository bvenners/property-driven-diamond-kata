package com.natpryce.diamond.examples

object Diamond {
  def diamond(maxLetter: DiamondChar) : String = {
    val topHalf = for (letter <- 'A' to maxLetter.value) yield lineFor(maxLetter.value, letter)
    (topHalf ++ topHalf.reverse.tail).mkString("\n")
  }

  def lineFor(maxLetter: Char, letter: Char): String = {
    val halfLength = ord(maxLetter)
    val letterIndex = halfLength - ord(letter)
    val halfLine = " "*letterIndex + letter + " "*(halfLength-letterIndex)

    halfLine ++ halfLine.reverse.tail
  }

  def ord(c: Char): Int = c - 'A'
}
