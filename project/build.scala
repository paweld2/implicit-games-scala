import sbt._
import sbt.Configuration
import sbt.Keys._


object ImplicitGamesBuild extends Build {
  lazy val Organization = "eu.pmsoft.scala"
  lazy val Name = "implicitGames"
  lazy val Version = "0.1.0-SNAPSHOT"


  lazy val root = Project(id = Name,
    base = file("."),
    settings = commonSettings ++ dependencies
  )


  lazy val commonSettings = Defaults.defaultSettings ++ Seq(
    organization := Organization,
    version := Version,
    scalacOptions in Compile ++= Seq("-unchecked", "-optimise", "-deprecation", "-feature"),
    resolvers += Classpaths.typesafeReleases
  )

  lazy val dependencies = Seq(
    libraryDependencies ++= Seq(
      "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
      "org.scalatest" %% "scalatest" % "2.2.0" % "test",
      "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
      "ch.qos.logback" % "logback-classic" % "1.1.2",
      "com.wix" %% "accord-core" % "0.4"
    )
  )

}
