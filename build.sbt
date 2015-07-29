
lazy val commonSettings = Seq(
  organization := "com.pacman",
  version := "0.1.0",
  scalaVersion := "2.11.4"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "Pacman",
    libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.3" % "test",
    scalacOptions in Test ++= Seq("-Yrangepos")
 )
