package com.natpryce.diamond.examples

import reflect.macros.Context
import org.scalactic.anyvals.CompileTimeAssertions

object DiamondCharMacro extends CompileTimeAssertions {
  def apply(c: Context)(value: c.Expr[Char]): c.Expr[DiamondChar] = {
    val notValidMsg =
      "DiamondChar.apply can only be invoked on Char literals 'A' to 'Z', like DiamondChar('C')."
    val notLiteralMsg =
      "DiamondChar.apply can only be invoked on Char literals, like " +
      "DiamondChar('C'). Please use DiamondChar.from instead."
    ensureValidCharLiteral(c)(value, notValidMsg, notLiteralMsg) { ch => DiamondChar.isValid(ch) }
    c.universe.reify { DiamondChar.from(value.splice).get }
  }
}

