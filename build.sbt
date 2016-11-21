//import sbt.Keys._
import sbt._

name := "scala-src"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor" % "2.4.6",
	"com.typesafe.akka" %% "akka-agent" % "2.4.6",
	"com.typesafe.akka" %% "akka-camel" % "2.4.6",
	"com.typesafe.akka" %% "akka-cluster" % "2.4.6",
	"com.typesafe.akka" %% "akka-cluster-metrics" % "2.4.6",
	"com.typesafe.akka" %% "akka-cluster-sharding" % "2.4.6",
	"com.typesafe.akka" %% "akka-cluster-tools" % "2.4.6",
	"com.typesafe.akka" %% "akka-contrib" % "2.4.6",
	"com.typesafe.akka" %% "akka-http-core" % "2.4.6",
	"com.typesafe.akka" %% "akka-http-testkit" % "2.4.6",
	"com.typesafe.akka" %% "akka-multi-node-testkit" % "2.4.6",
	"com.typesafe.akka" %% "akka-osgi" % "2.4.6",
	"com.typesafe.akka" %% "akka-persistence" % "2.4.6",
	"com.typesafe.akka" %% "akka-persistence-tck" % "2.4.6",
	"com.typesafe.akka" %% "akka-remote" % "2.4.6",
	"com.typesafe.akka" %% "akka-slf4j" % "2.4.6",
	"com.typesafe.akka" %% "akka-stream" % "2.4.6",
	"com.typesafe.akka" %% "akka-stream-testkit" % "2.4.6",
	"com.typesafe.akka" %% "akka-testkit" % "2.4.6",
	"com.typesafe.akka" %% "akka-distributed-data-experimental" % "2.4.6",
	"com.typesafe.akka" %% "akka-typed-experimental" % "2.4.6",
	"com.typesafe.akka" %% "akka-http-experimental" % "2.4.6",
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.6",
	"com.typesafe.akka" %% "akka-http-jackson-experimental" % "2.4.6",
	"com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.6",
	"com.typesafe.akka" %% "akka-http-xml-experimental" % "2.4.6",
	"com.typesafe.akka" %% "akka-persistence-query-experimental" % "2.4.6",
	"com.typesafe.akka" %% "akka-typed-experimental" % "2.4.6",
  	"org.scalatest" %% "scalatest" % "2.2.5" % "test",
  	"io.spray" %%  "spray-json" % "1.3.2",
  	"org.apache.spark" %% "spark-core" % "1.6.2",
  	"org.apache.spark" % "spark-streaming_2.11" % "1.6.2",
  	"org.apache.spark" % "spark-sql_2.11" % "1.6.2",
  	"org.apache.spark" % "spark-hive_2.11" % "1.6.2"
)