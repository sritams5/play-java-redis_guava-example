name := """play-java-redis-guava-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
val lettuceVersion = "4.4.2.Final"
val guavaVersion = "4.4.2.Final"
val elasticVersion = "6.2.4"
scalaVersion := "2.11.8"


libraryDependencies += guice

libraryDependencies ++= Seq(
  "biz.paluch.redis" % "lettuce" % lettuceVersion,
  "com.google.guava" % "guava" % guavaVersion,

  "org.elasticsearch" % "elasticsearch" % elasticVersion,
  "org.elasticsearch.client" % "transport" % elasticVersion,
  "com.google.code.gson" % "gson" % "2.2"
)




