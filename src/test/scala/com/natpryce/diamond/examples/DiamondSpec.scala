package com.natpryce.diamond.examples

import org.scalacheck._

class DiamondSpec extends UnitSpec {
  val inputChar = Gen.alphaUpperChar

  def ord(c: Char) : Int = c - 'A'

  "number of lines" in {
    forAll (inputChar) { c => assert(diamondLines(c).length == ord(c)+1) }
  }

  def diamondLines(c : Char) = {
    Diamond.diamond(c).lines.toVector
  }

}
