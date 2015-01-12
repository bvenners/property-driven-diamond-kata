Compile-time assertions coming soon in Scalactic 3.0
====================================================

At the end of [Diamond Kata - TDD with only Property-Based Tests](http://natpryce.com/articles/000807.html), Nat Pryce writes:

> I also didn't address what the diamond function would do with
> input outside the range of `'A'` to `'Z'`. Scala doesn't let one
> define a subtype of `Char`, so I can't enforce the input constraint
> in the type system. I guess the Scala way would be to define
> diamond as a `PartialFunction[Char,String]`.

The compile-time-assertions branch of this fork of Nat's project shows how the compile-time asserions of Scalactic 3.0 can help users create a macro that gives a compiler error for invalid `Char` literals. Here's a quick demo:

    scala> import com.natpryce.diamond.examples._
    import com.natpryce.diamond.examples._
    
    scala> println(Diamond.diamond('C'))
      A  
     B B 
    C   C
     B B 
      A  
    
    scala> println(Diamond.diamond('H'))
           A       
          B B      
         C   C     
        D     D    
       E       E   
      F         F  
     G           G 
    H             H
     G           G 
      F         F  
       E       E   
        D     D    
         C   C     
          B B      
           A       
    
    scala> println(Diamond.diamond('h'))
    <console>:17: error: DiamondChar.apply can only be invoked on Char literals 'A' to 'Z', like DiamondChar('C').
                  println(Diamond.diamond('h'))
                                          ^
    
    scala> println(Diamond.diamond('*'))
    <console>:17: error: DiamondChar.apply can only be invoked on Char literals 'A' to 'Z', like DiamondChar('C').
                  println(Diamond.diamond('*'))
                                          ^
    
