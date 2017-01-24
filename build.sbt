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
 	"com.typesafe.akka" %% "akka-actor"   % akkaVersion,
  	"com.typesafe.akka" %% "akka-slf4j"   % akkaVersion,
  	"com.typesafe.akka" %% "akka-remote"  % akkaVersion,
  	"com.typesafe.akka" %% "akka-agent"   % akkaVersion,
	
	/*  Akka streams */
	"com.typesafe.akka" %% "akka-stream" % akkaVersion,
	
	/*  Akka http */
	"com.typesafe.akka" %% "akka-http-core" % akkaVersion,
	"com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
	"com.typesafe.akka" %% "akka-http-testkit" % akkaVersion % "test",
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
    
  	/* Spray */
  	"io.spray" %%  "spray-json" % "1.3.2",
  	
  	/* Spark */
	"org.apache.spark" %% "spark-core" % sparkVersion,
	"org.apache.spark" %% "spark-sql" % sparkVersion,
	"org.apache.spark" %% "spark-mllib" % sparkVersion,
	"org.apache.spark" %% "spark-streaming" % sparkVersion,
	"org.apache.spark" %% "spark-hive" % sparkVersion,
  	
	/* Scalatest */
  	"org.scalatest" %% "scalatest" % "2.2.5" % "test",
  	
  	/* MS SQL Server JDBC driver */
  	"com.microsoft.sqlserver" % "mssql-jdbc" % "6.1.0.jre7"
)

dependencyOverrides ++= Set(

  	/* Fasterxml */
  	"com.fasterxml.jackson.core" %% "jackson-core" % fasterxmlVersion,
  	"com.fasterxml.jackson.core" %% "jackson-databind" % fasterxmlVersion
)