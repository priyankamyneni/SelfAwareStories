name := """SelfAwareStories"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
lazy val myProject = (project in file("."))
 .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  "org.mindrot" % "jbcrypt" % "0.3m",
 //"mysql" % "mysql-connector-java" % "5.1.28",
  javaWs
)
libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1100-jdbc41"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
