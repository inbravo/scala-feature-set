import sbt._

name := "scala-src"

version := "1.0"

scalaVersion := "2.11.8"
val sparkVersion = "2.0.2"
val akkaVersion = "2.4.6"
val fasterxmlVersion = "2.8.4"

libraryDependencies ++= Seq(

	/* Standard format : libraryDependencies += groupID % artifactID % revision */
	
	/* Akka - Comment all dependencies to avoid runtime issues with Spark */
	/*
	"com.typesafe.akka" %% "akka-actor" % akkaVersion,
	"com.typesafe.akka" %% "akka-agent" % akkaVersion,
	"com.typesafe.akka" %% "akka-camel" % akkaVersion,
	"com.typesafe.akka" %% "akka-cluster" % akkaVersion,
	"com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
	"com.typesafe.akka" %% "akka-cluster-sharding" % akkaVersion,
	"com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
	"com.typesafe.akka" %% "akka-contrib" % akkaVersion,
	"com.typesafe.akka" %% "akka-http-core" % akkaVersion,
	"com.typesafe.akka" %% "akka-http-testkit" % akkaVersion,
	"com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion,
	"com.typesafe.akka" %% "akka-osgi" % akkaVersion,
	"com.typesafe.akka" %% "akka-persistence" % akkaVersion,
	"com.typesafe.akka" %% "akka-persistence-tck" % akkaVersion,
	"com.typesafe.akka" %% "akka-remote" % akkaVersion,
	"com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
	"com.typesafe.akka" %% "akka-stream" % akkaVersion,
	"com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion,
	"com.typesafe.akka" %% "akka-testkit" % akkaVersion,
	"com.typesafe.akka" %% "akka-distributed-data-experimental" % akkaVersion,
	"com.typesafe.akka" %% "akka-typed-experimental" % akkaVersion,
	"com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
	"com.typesafe.akka" %% "akka-http-jackson-experimental" % akkaVersion,
	"com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
	"com.typesafe.akka" %% "akka-http-xml-experimental" % akkaVersion,
	"com.typesafe.akka" %% "akka-persistence-query-experimental" % akkaVersion,
	"com.typesafe.akka" %% "akka-typed-experimental" % akkaVersion,
  	*/
  	
  	/* Spray */
  	"io.spray" %%  "spray-json" % "1.3.2",
  	
  	/* Spark */
	"org.apache.spark" %% "spark-core" % sparkVersion,
	"org.apache.spark" %% "spark-sql" % sparkVersion,
	"org.apache.spark" %% "spark-mllib" % sparkVersion,
	"org.apache.spark" %% "spark-streaming" % sparkVersion,
	"org.apache.spark" %% "spark-hive" % sparkVersion,
  	
	/* Scalatest */
  	"org.scalatest" %% "scalatest" % "2.2.5" % "test"
)

dependencyOverrides ++= Set(

  	/* Fasterxml */
  	"com.fasterxml.jackson.core" %% "jackson-core" % fasterxmlVersion,
  	"com.fasterxml.jackson.core" %% "jackson-databind" % fasterxmlVersion
)