package com.natpryce.diamond.examples

import com.natpryce.diamond.examples.Diamond.ord
import org.scalacheck._

import scala.collection.generic.CanBuildFrom

class DiamondSpec extends UnitSpec {
  val inputChar = Gen.alphaUpperChar

  "squareness" in {
    forAll (inputChar) { c =>
      val lines = diamondLines(c)
      assert(lines forall {line => line.length == lines.length}) }
  }

  "size of square" in {
    forAll (inputChar) { c => assert(diamondLines(c).length == 2*ord(c) + 1) }
  }

  "is vertically symmetrical" in {
    forAll (inputChar) { c =>
      val lines = diamondLines(c)

      assert(firstHalfOf(lines) == secondHalfOf(lines).reverse)
    }
  }
  
  "is horizontally symmetrical" in {
    forAll (inputChar) { c =>
      for ((line, index) <- diamondLines(c).zipWithIndex) {
        assert(firstHalfOf(line) == secondHalfOf(line).reverse,
          "line " + index + " should be symmetrical")
      }
    }
  }

  "position of letter in line of spaces" in {
    forAll (inputChar) { c =>
      for ((line, lineIndex) <- firstHalfOf(diamondLines(c)).zipWithIndex) {
        val firstHalf = firstHalfOf(line)
        val expectedLetter = ('A'+lineIndex).toChar
        val letterIndex = firstHalf.length - (lineIndex + 1)

        assert (firstHalf(letterIndex) == expectedLetter, firstHalf)
        assert (firstHalf.count(_==' ') == firstHalf.length-1, "number of spaces in line " + lineIndex + ": " + line)
      }
    }
  }

  "non-valid character literals passed to DiamondChar fail to compile" in {
    assertTypeError("""DiamondChar('a')""")
    assertTypeError("""DiamondChar('b')""")
    assertTypeError("""DiamondChar('c')""")
    assertTypeError("""DiamondChar('d')""")
    assertTypeError("""DiamondChar('e')""")
    assertTypeError("""DiamondChar('f')""")
    assertTypeError("""DiamondChar('g')""")
    assertTypeError("""DiamondChar('h')""")
    assertTypeError("""DiamondChar('i')""")
    assertTypeError("""DiamondChar('j')""")
    assertTypeError("""DiamondChar('k')""")
    assertTypeError("""DiamondChar('l')""")
    assertTypeError("""DiamondChar('m')""")
    assertTypeError("""DiamondChar('n')""")
    assertTypeError("""DiamondChar('o')""")
    assertTypeError("""DiamondChar('p')""")
    assertTypeError("""DiamondChar('q')""")
    assertTypeError("""DiamondChar('r')""")
    assertTypeError("""DiamondChar('s')""")
    assertTypeError("""DiamondChar('t')""")
    assertTypeError("""DiamondChar('u')""")
    assertTypeError("""DiamondChar('v')""")
    assertTypeError("""DiamondChar('w')""")
    assertTypeError("""DiamondChar('x')""")
    assertTypeError("""DiamondChar('y')""")
    assertTypeError("""DiamondChar('z')""")
    assertTypeError("""DiamondChar('1')""")
    assertTypeError("""DiamondChar('2')""")
    assertTypeError("""DiamondChar('3')""")
    assertTypeError("""DiamondChar('4')""")
    assertTypeError("""DiamondChar('5')""")
    assertTypeError("""DiamondChar('6')""")
    assertTypeError("""DiamondChar('7')""")
    assertTypeError("""DiamondChar('8')""")
    assertTypeError("""DiamondChar('9')""")
    assertTypeError("""DiamondChar('0')""")
    assertTypeError("""DiamondChar('~')""")
    assertTypeError("""DiamondChar('!')""")
    assertTypeError("""DiamondChar('@')""")
    assertTypeError("""DiamondChar('#')""")
    assertTypeError("""DiamondChar('$')""")
    assertTypeError("""DiamondChar('%')""")
    assertTypeError("""DiamondChar('^')""")
    assertTypeError("""DiamondChar('&')""")
    assertTypeError("""DiamondChar('*')""")
    assertTypeError("""DiamondChar('(')""")
    assertTypeError("""DiamondChar(')')""")
    assertTypeError("""DiamondChar('_')""")
    assertTypeError("""DiamondChar('+')""")
    assertTypeError("""DiamondChar('-')""")
    assertTypeError("""DiamondChar('=')""")
    assertTypeError("""DiamondChar('{')""")
    assertTypeError("""DiamondChar('}')""")
    assertTypeError("""DiamondChar('[')""")
    assertTypeError("""DiamondChar(']')""")
    assertTypeError("""DiamondChar('\\')""")
    assertTypeError("""DiamondChar('|')""")
    assertTypeError("""DiamondChar(''')""")
    assertTypeError("""DiamondChar(':')""")
    assertTypeError("""DiamondChar(';')""")
    assertTypeError("""DiamondChar('<')""")
    assertTypeError("""DiamondChar('>')""")
    assertTypeError("""DiamondChar(',')""")
    assertTypeError("""DiamondChar('.')""")
    assertTypeError("""DiamondChar('?')""")
    assertTypeError("""DiamondChar('/')""")
    assertTypeError("""DiamondChar('"')""")
  }

  def firstHalfOf[AS, A, That](v: AS)(implicit asSeq: AS => Seq[A], cbf: CanBuildFrom[AS, A, That]) = {
    v.slice(0, (v.length+1)/2)
  }

  def secondHalfOf[AS, A, That](v: AS)(implicit asSeq: AS => Seq[A], cbf: CanBuildFrom[AS, A, That]) = {
    v.slice(v.length/2, v.length)
  }
  
  def diamondLines(c : Char) = {
    val diamondChar = DiamondChar.from(c).get
    Diamond.diamond(diamondChar).lines.toVector
  }
}
