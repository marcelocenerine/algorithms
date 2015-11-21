organization := "com.cenerino"

name := "algorithms"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.8" % "test->default",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
