import sbt._
import Keys._

object MacroBuild extends Build {
   lazy val main = Project("main", file(".")).dependsOn(macroSub).settings(
     scalaVersion := "2.11.4",
     libraryDependencies += "junit" % "junit" % "4.12" % "test",
     libraryDependencies += "org.scalactic" % "scalactic_2.11" % "3.0.0-SNAP4",
     libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0-SNAP4" % "test",
     libraryDependencies += "org.scalacheck" % "scalacheck_2.11" % "1.12.1" % "test",
     initialCommands in console := "import com.natpryce.diamond.examples._",
     libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
   )
   lazy val macroSub = Project("macro", file("macro")).settings(
     scalaVersion := "2.11.4",
     libraryDependencies += "junit" % "junit" % "4.12" % "test",
     libraryDependencies += "org.scalactic" % "scalactic_2.11" % "3.0.0-SNAP4",
     libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0-SNAP4" % "test",
     libraryDependencies += "org.scalacheck" % "scalacheck_2.11" % "1.12.1" % "test",
     initialCommands in console := "import com.natpryce.diamond.examples._",
     libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
   )
}
/*
lazy val main = Project("main", file(".")) dependsOn(macroSub)
   lazy val macroSub = Project("macro", file("macro")) settings(
      libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)
   )
*/
