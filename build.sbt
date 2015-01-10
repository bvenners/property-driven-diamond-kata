scalaVersion := "2.11.4"

libraryDependencies += "junit" % "junit" % "4.12"

libraryDependencies += "org.scalactic" % "scalactic_2.11" % "3.0.0-SNAP4"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0-SNAP4" % "test"

libraryDependencies += "org.scalacheck" % "scalacheck_2.11" % "1.12.1" % "test"

initialCommands in console := "import com.natpryce.diamond.examples._"

