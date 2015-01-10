
package com.natpryce.diamond.examples

final class DiamondChar private (val value: Char) extends AnyVal {
  override def toString: String = s"DiamondChar($value)"
}

object DiamondChar {
  def from(value: Char): Option[DiamondChar] =
    if (value % 2 == 1) Some(new DiamondChar(value)) else None
  import scala.language.experimental.macros
  def apply(value: Char): DiamondChar = macro DiamondCharMacro.apply
  def isValid(c: Char): Boolean = c >= 'A' && c <= 'Z'
}     

